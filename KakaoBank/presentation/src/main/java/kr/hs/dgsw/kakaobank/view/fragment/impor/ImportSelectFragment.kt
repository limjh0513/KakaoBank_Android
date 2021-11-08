package kr.hs.dgsw.kakaobank.view.fragment.impor

import kr.hs.dgsw.kakaobank.R
import kr.hs.dgsw.kakaobank.base.BaseFragment
import kr.hs.dgsw.kakaobank.databinding.FragmentImportSelectBinding
import kr.hs.dgsw.kakaobank.viewmodel.impor.ImportSelectViewModel
import org.koin.android.ext.android.inject


class ImportSelectFragment : BaseFragment<FragmentImportSelectBinding, ImportSelectViewModel>() {
    override val mViewModel: ImportSelectViewModel by inject()
    override val layoutRes: Int
        get() = R.layout.fragment_import_select

    override fun observerViewModel() {
        with(mViewModel){

        }
    }

}