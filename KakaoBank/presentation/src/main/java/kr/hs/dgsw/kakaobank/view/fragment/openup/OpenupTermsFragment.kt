package kr.hs.dgsw.kakaobank.view.fragment.openup

import android.content.Intent
import android.net.Uri
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import kr.hs.dgsw.kakaobank.R
import kr.hs.dgsw.kakaobank.base.BaseFragment
import kr.hs.dgsw.kakaobank.databinding.FragmentOpenupTermsBinding
import kr.hs.dgsw.kakaobank.view.activity.terms.BorrowAccountActivity
import kr.hs.dgsw.kakaobank.view.activity.terms.InforAccountAcitivty
import kr.hs.dgsw.kakaobank.viewmodel.openup.OpenupTermsViewModel
import org.koin.android.ext.android.inject

class OpenupTermsFragment : BaseFragment<FragmentOpenupTermsBinding, OpenupTermsViewModel>() {
    override val mViewModel: OpenupTermsViewModel by inject()
    override val layoutRes: Int
        get() = R.layout.fragment_openup_terms

    private var check = IntArray(3)

    override fun observerViewModel() {
        with(mViewModel) {
            termsMainShowBtn.observe(this@OpenupTermsFragment, Observer {
                val intent =
                    Intent(Intent.ACTION_VIEW, Uri.parse("https://m.kakaobank.com/ServicePolicy"))
                startActivity(intent)
            })

            termsMainIsChecked.observe(this@OpenupTermsFragment, Observer {
                if (it) {
                    check[0] = 1
                } else {
                    check[0] = 0
                }
                checkBoxCheck()
            })

            termsShowBtn1.observe(this@OpenupTermsFragment, Observer {
                val intent = Intent(requireContext(), InforAccountAcitivty::class.java)
                startActivity(intent)
            })

            termsIsChecked1.observe(this@OpenupTermsFragment, Observer {
                if (it) {
                    check[1] = 1
                } else {
                    check[1] = 0
                }
                checkBoxCheck()
            })

            termsShowBtn2.observe(this@OpenupTermsFragment, Observer {
                val intent = Intent(requireContext(), BorrowAccountActivity::class.java)
                startActivity(intent)
            })

            termsIsChecked2.observe(this@OpenupTermsFragment, Observer {
                if (it) {
                    check[2] = 1
                } else {
                    check[2] = 0
                }
                checkBoxCheck()
            })
        }
    }

    fun checkBoxCheck() {
        var result = true

        for (i in check){
            if(check[i] != 1){
                result = false
                break;
            }
        }

        if(result){
            mBinding.openTNextBtn.setBackgroundColor(ContextCompat.getColor(requireContext(),
                R.color.kakao))
            mBinding.openTNextBtn.setTextColor(ContextCompat.getColor(requireContext(),
                R.color.text_mainColor))
            mBinding.openTNextBtn.setOnClickListener {
                //this.findNavController()
                    //.navigate(R.id.)
            }
        } else {
            mBinding.openTNextBtn.setBackgroundColor(ContextCompat.getColor(requireContext(),
                R.color.disabled))
            mBinding.openTNextBtn.setTextColor(ContextCompat.getColor(requireContext(),
                R.color.disabled_text))
            mBinding.openTNextBtn.setOnClickListener {
            }
        }
    }
}