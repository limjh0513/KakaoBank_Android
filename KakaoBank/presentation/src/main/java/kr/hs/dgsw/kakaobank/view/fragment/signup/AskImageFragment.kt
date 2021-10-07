package kr.hs.dgsw.kakaobank.view.fragment.signup

import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import kr.hs.dgsw.kakaobank.R
import kr.hs.dgsw.kakaobank.base.BaseFragment
import kr.hs.dgsw.kakaobank.databinding.FragmentAskImageBinding
import kr.hs.dgsw.kakaobank.viewmodel.signup.AskImageViewModel
import org.koin.android.ext.android.inject

class AskImageFragment : BaseFragment<FragmentAskImageBinding, AskImageViewModel>() {
    override val mViewModel: AskImageViewModel by inject()
    override val layoutRes: Int
        get() = R.layout.fragment_ask_image

    override fun observerViewModel() {
        with(mViewModel) {
            negativeBtn.observe(this@AskImageFragment, Observer {
                this@AskImageFragment.findNavController()
                    .navigate(R.id.action_askImageFragment_to_signupSelectImgFramgent)
            })

            positiveBtn.observe(this@AskImageFragment, Observer {
                this@AskImageFragment.findNavController()
                    .navigate(R.id.action_askImageFragment_to_signupPasswordFramgent)
            })
        }
    }
}