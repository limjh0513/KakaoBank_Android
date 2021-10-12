package kr.hs.dgsw.kakaobank.view.fragment.openup

import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import kr.hs.dgsw.kakaobank.R
import kr.hs.dgsw.kakaobank.base.BaseFragment
import kr.hs.dgsw.kakaobank.databinding.FragmentBankbookNickBinding
import kr.hs.dgsw.kakaobank.viewmodel.openup.BankBookNickViewModel
import org.koin.android.ext.android.inject


class BankbookNickFragment : BaseFragment<FragmentBankbookNickBinding, BankBookNickViewModel>() {
    override val mViewModel: BankBookNickViewModel by inject()
    override val layoutRes: Int
        get() = R.layout.fragment_bankbook_nick

    override fun observerViewModel() {
        with(mViewModel){
            bankBookNickName.observe(this@BankbookNickFragment, Observer {
                if(it.length > 1){
                    mBinding.bankBookNextBtn.setBackgroundColor(ContextCompat.getColor(requireContext(),
                        R.color.kakao))
                    mBinding.bankBookNextBtn.setTextColor(ContextCompat.getColor(requireContext(),
                        R.color.text_mainColor))
                    mBinding.bankBookNextBtn.setOnClickListener {
                        this@BankbookNickFragment.findNavController()
                            .navigate(R.id.action_openupInputFragment_to_bankbookNickFragment)
                    }
                } else {
                    mBinding.bankBookNextBtn.setBackgroundColor(ContextCompat.getColor(requireContext(),
                        R.color.disabled))
                    mBinding.bankBookNextBtn.setTextColor(ContextCompat.getColor(requireContext(),
                        R.color.disabled_text))
                    mBinding.bankBookNextBtn.setOnClickListener {
                    }
                }
            })
        }
    }

}