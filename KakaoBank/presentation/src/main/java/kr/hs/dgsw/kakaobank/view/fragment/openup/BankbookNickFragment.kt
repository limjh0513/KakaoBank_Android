package kr.hs.dgsw.kakaobank.view.fragment.openup

import android.app.Activity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import kr.hs.dgsw.kakaobank.R
import kr.hs.dgsw.kakaobank.base.BaseFragment
import kr.hs.dgsw.kakaobank.databinding.FragmentBankbookNickBinding
import kr.hs.dgsw.kakaobank.view.activity.OpenupActivity
import kr.hs.dgsw.kakaobank.view.activity.SignupActivity
import kr.hs.dgsw.kakaobank.viewmodel.openup.BankBookNickViewModel
import org.koin.android.ext.android.inject


class BankbookNickFragment : BaseFragment<FragmentBankbookNickBinding, BankBookNickViewModel>() {
    override val mViewModel: BankBookNickViewModel by inject()
    override val layoutRes: Int
        get() = R.layout.fragment_bankbook_nick

    override fun observerViewModel() {
        setPersonalText()

        with(mViewModel) {
            bankBookNickName.observe(this@BankbookNickFragment, Observer {
                if (it.length > 1) {
                    mBinding.bankBookNextBtn.setBackgroundColor(ContextCompat.getColor(
                        requireContext(),
                        R.color.kakao))
                    mBinding.bankBookNextBtn.setTextColor(ContextCompat.getColor(requireContext(),
                        R.color.text_mainColor))
                    mBinding.bankBookNextBtn.setOnClickListener {
                        (activity as OpenupActivity).request.nickname = this.bankBookNickName.value.toString()
                        this@BankbookNickFragment.findNavController()
                            .navigate(R.id.action_bankbookNickFragment_to_openupPasswordFragment)
                    }
                } else {
                    mBinding.bankBookNextBtn.setBackgroundColor(ContextCompat.getColor(
                        requireContext(),
                        R.color.disabled))
                    mBinding.bankBookNextBtn.setTextColor(ContextCompat.getColor(requireContext(),
                        R.color.disabled_text))
                    mBinding.bankBookNextBtn.setOnClickListener {
                    }
                }
            })
        }
    }

    private fun setPersonalText() {
        mBinding.bookBankTvName.text = arguments?.getString("name")
        mBinding.bookBankTvRegist.text = arguments?.getString("residentNumber")
    }

}