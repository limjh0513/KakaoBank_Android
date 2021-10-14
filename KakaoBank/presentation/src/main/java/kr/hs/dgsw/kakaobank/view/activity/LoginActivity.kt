package kr.hs.dgsw.kakaobank.view.activity

import android.content.Intent
import androidx.lifecycle.Observer
import kr.hs.dgsw.domain.request.RegisterRequest
import kr.hs.dgsw.kakaobank.R
import kr.hs.dgsw.kakaobank.base.BaseActivity
import kr.hs.dgsw.kakaobank.databinding.ActivityLoginBinding
import kr.hs.dgsw.kakaobank.viewmodel.LoginViewModel
import org.koin.android.ext.android.inject

class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>() {
    override val mViewModel: LoginViewModel by inject()
    override val layoutRes: Int
        get() = R.layout.activity_login

    override fun observerViewModel() {
        with(mViewModel) {
            backBtn.observe(this@LoginActivity, Observer {
                finish()
            })
            loginBtn.observe(this@LoginActivity, Observer {
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                startActivity(intent)
            })
        }
    }

}