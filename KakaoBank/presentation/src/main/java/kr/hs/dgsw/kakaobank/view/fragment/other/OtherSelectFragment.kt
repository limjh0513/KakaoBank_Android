package kr.hs.dgsw.kakaobank.view.fragment.other

import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import kr.hs.dgsw.data.util.SharedPreferenceManager
import kr.hs.dgsw.domain.model.Account
import kr.hs.dgsw.domain.model.OtherAccount
import kr.hs.dgsw.domain.request.OtherAccountRequest
import kr.hs.dgsw.kakaobank.R
import kr.hs.dgsw.kakaobank.base.BaseFragment
import kr.hs.dgsw.kakaobank.databinding.FragmentOtherSelectBinding
import kr.hs.dgsw.kakaobank.view.activity.OtherSuccessActivity
import kr.hs.dgsw.kakaobank.viewmodel.other.OtherSelectViewModel
import kr.hs.dgsw.kakaobank.widget.adapter.AccountOtherItemAdapter
import org.koin.android.ext.android.inject
import java.io.Serializable


class OtherSelectFragment : BaseFragment<FragmentOtherSelectBinding, OtherSelectViewModel>() {
    override val mViewModel: OtherSelectViewModel by inject()
    override val layoutRes: Int
        get() = R.layout.fragment_other_select

    var postResultList: ArrayList<OtherAccount> = ArrayList()
    var isEnded: Boolean = false

    override fun observerViewModel() {
        mViewModel.getOtherBankAccount("Bearer ${SharedPreferenceManager.getToken(requireContext())}")

        with(mViewModel) {
            otherBankList.observe(this@OtherSelectFragment, Observer {

                Log.e("asdfasdff", it.size.toString())

                if (it.size <= 0) {
                    mBinding.otherSViewHint.visibility = View.VISIBLE
                    mBinding.importSTvHint.text = "카카오 뱅크로 가져올\n다른 은행 계좌가\n존재하지 않습니다."
                } else {
                    mBinding.otherSViewHint.visibility = View.INVISIBLE
                    val accountAdapter = AccountOtherItemAdapter()
                    accountAdapter.items = it
                    accountAdapter.context = requireContext()
                    accountAdapter.mViewModel = mViewModel

                    mBinding.otherSRecycler.adapter = accountAdapter
                }
            })

            onErrorEvent.observe(this@OtherSelectFragment, Observer {
                mBinding.otherSViewHint.visibility = View.VISIBLE
                mBinding.importSTvHint.text = "다른 데이터를 전달 받는 중\n문제가 발생했습니다.\n다시 시도해주세요"
                Toast.makeText(requireContext(), "다른 은행의 계좌를 전달받지 못했습니다.", Toast.LENGTH_SHORT)
                    .show()
            })

            selectList.observe(this@OtherSelectFragment, Observer {
                if (it.isNotEmpty()) {
                    mBinding.otherSNextBtn.setBackgroundColor(ContextCompat.getColor(requireContext(),
                        R.color.kakao))
                    mBinding.otherSNextBtn.setTextColor(ContextCompat.getColor(requireContext(),
                        R.color.text_mainColor))
                    mBinding.otherSNextBtn.setOnClickListener {
                        val accounts: List<Account>? = mViewModel.selectList.value
                        for (ac in accounts!!) {
                            val request = OtherAccountRequest(ac.accountNumber,
                                ac.kindOfBank,
                                ac.money,
                                ac.nickname)
                            sendPostOtherRequest(request)
                        }
                        isEnded = true
                    }

                } else {
                    mBinding.otherSNextBtn.setBackgroundColor(ContextCompat.getColor(requireContext(),
                        R.color.disabled))
                    mBinding.otherSNextBtn.setTextColor(ContextCompat.getColor(requireContext(),
                        R.color.disabled_text))
                    mBinding.otherSNextBtn.setOnClickListener {
                    }
                }
            })

            postOnSuccess.observe(this@OtherSelectFragment, Observer {
                postResultList.add(it)


                Log.e("adsf", postResultList.size.toString())
                if (isEnded) {
                    val intent = Intent(requireContext(), OtherSuccessActivity::class.java)
                    intent.putExtra("postResultList", postResultList)
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
                    startActivity(intent)
                    requireActivity().finish()
                }
            })

            postOnError.observe(this@OtherSelectFragment, Observer {
                postResultList.add(it)
                Log.e("adsf", postResultList.size.toString())
                if (isEnded) {
                    val intent = Intent(requireContext(), OtherSuccessActivity::class.java)
                    intent.putExtra("postResultList", postResultList)
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
                    startActivity(intent)
                    requireActivity().finish()
                }
            })
        }
    }

    fun sendPostOtherRequest(request: OtherAccountRequest) {
        val token = SharedPreferenceManager.getToken(requireContext())

        if (token != null) {
            mViewModel.postOtherBankAccount("Bearer $token", request)
        }
    }

}