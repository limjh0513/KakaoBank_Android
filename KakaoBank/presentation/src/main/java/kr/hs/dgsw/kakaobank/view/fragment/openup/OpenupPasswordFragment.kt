package kr.hs.dgsw.kakaobank.view.fragment.openup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kr.hs.dgsw.kakaobank.R
import kr.hs.dgsw.kakaobank.base.BaseFragment
import kr.hs.dgsw.kakaobank.databinding.FragmentOpenupPasswordBinding
import kr.hs.dgsw.kakaobank.viewmodel.openup.OpenupPasswordViewModel
import org.koin.android.ext.android.inject

class OpenupPasswordFragment : BaseFragment<FragmentOpenupPasswordBinding, OpenupPasswordViewModel>() {
    override val mViewModel: OpenupPasswordViewModel by inject()
    override val layoutRes: Int
        get() = R.layout.fragment_openup_password

    override fun observerViewModel() {
    }

}