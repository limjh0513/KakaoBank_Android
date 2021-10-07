package kr.hs.dgsw.kakaobank.view.fragment.openup

import kr.hs.dgsw.kakaobank.R
import kr.hs.dgsw.kakaobank.base.BaseFragment
import kr.hs.dgsw.kakaobank.databinding.FragmentOpenupInputBinding
import kr.hs.dgsw.kakaobank.viewmodel.openup.OpenupInputViewModel
import org.koin.android.ext.android.inject


class OpenupInputFragment : BaseFragment<FragmentOpenupInputBinding, OpenupInputViewModel>() {
    override val mViewModel: OpenupInputViewModel by inject()
    override val layoutRes: Int
        get() = R.layout.fragment_openup_input

    override fun observerViewModel() {
    }

}