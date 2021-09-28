package kr.hs.dgsw.kakaobank.view.activity

import kr.hs.dgsw.kakaobank.R
import kr.hs.dgsw.kakaobank.base.BaseActivity
import kr.hs.dgsw.kakaobank.databinding.ActivitySignupBinding
import kr.hs.dgsw.kakaobank.viewmodel.SignupViewModel
import androidx.lifecycle.Observer
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.getViewModel

class SignupActivity : BaseActivity<ActivitySignupBinding, SignupViewModel>() {
    override val viewModel: SignupViewModel by inject()
    override val layoutRes: Int
        get() = R.layout.activity_signup

    override fun observerViewModel() {
        with(viewModel){
            cancelBtn.observe(this@SignupActivity, Observer{
                this@SignupActivity.finish()
            })

            initSignupFragment.observe(this@SignupActivity, Observer{
            })
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}