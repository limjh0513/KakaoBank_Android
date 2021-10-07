package kr.hs.dgsw.kakaobank.view.fragment.openup

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
    }

}