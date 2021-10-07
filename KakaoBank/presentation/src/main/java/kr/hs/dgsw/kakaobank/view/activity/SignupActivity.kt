package kr.hs.dgsw.kakaobank.view.activity

import kr.hs.dgsw.kakaobank.R
import kr.hs.dgsw.kakaobank.base.BaseActivity
import kr.hs.dgsw.kakaobank.databinding.ActivitySignupBinding
import kr.hs.dgsw.kakaobank.viewmodel.SignupViewModel
import androidx.lifecycle.Observer
import org.koin.android.ext.android.inject

class SignupActivity : BaseActivity<ActivitySignupBinding, SignupViewModel>() {
    override val mViewModel: SignupViewModel by inject()
    override val layoutRes: Int
        get() = R.layout.activity_signup

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