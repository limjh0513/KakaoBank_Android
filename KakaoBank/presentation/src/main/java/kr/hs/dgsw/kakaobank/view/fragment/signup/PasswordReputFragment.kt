package kr.hs.dgsw.kakaobank.view.fragment.signup

import kr.hs.dgsw.kakaobank.R
import kr.hs.dgsw.kakaobank.base.BaseFragment
import kr.hs.dgsw.kakaobank.databinding.FragmentPasswordReputBinding
import kr.hs.dgsw.kakaobank.viewmodel.signup.PasswordReputViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.getViewModel


class PasswordReputFragment : BaseFragment<FragmentPasswordReputBinding, PasswordReputViewModel>() {
    override val mViewModel: PasswordReputViewModel by inject()
    override val layoutRes: Int
        get() = R.layout.fragment_password_reput

    override fun observerViewModel() {
    }

}