package kr.hs.dgsw.kakaobank.view.activity

import kr.hs.dgsw.kakaobank.R
import kr.hs.dgsw.kakaobank.base.BaseActivity
import kr.hs.dgsw.kakaobank.databinding.ActivitySignupBinding
import kr.hs.dgsw.kakaobank.viewmodel.SignupViewModel
import androidx.lifecycle.Observer
import kr.hs.dgsw.domain.request.LoginRequest
import kr.hs.dgsw.domain.request.RegisterRequest
import org.koin.android.ext.android.inject

class SignupActivity : BaseActivity<ActivitySignupBinding, SignupViewModel>() {
    override val mViewModel: SignupViewModel by inject()
    override val layoutRes: Int
        get() = R.layout.activity_signup

    var request = RegisterRequest()

    override fun observerViewModel() {
        with(mViewModel) {
            cancelBtn.observe(this@SignupActivity, Observer {
                this@SignupActivity.finish()
            })
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}