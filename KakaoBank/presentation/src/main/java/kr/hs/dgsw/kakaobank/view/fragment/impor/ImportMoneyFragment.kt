package kr.hs.dgsw.kakaobank.view.fragment.impor

import kr.hs.dgsw.kakaobank.R
import kr.hs.dgsw.kakaobank.base.BaseFragment
import kr.hs.dgsw.kakaobank.databinding.FragmentImportMoneyBinding
import kr.hs.dgsw.kakaobank.viewmodel.impor.ImportMoneyViewModel
import org.koin.android.ext.android.inject

class ImportMoneyFragment : BaseFragment<FragmentImportMoneyBinding, ImportMoneyViewModel>() {
    override val mViewModel: ImportMoneyViewModel by inject()
    override val layoutRes: Int
        get() = R.layout.fragment_import_money

    override fun observerViewModel() {
    }

}