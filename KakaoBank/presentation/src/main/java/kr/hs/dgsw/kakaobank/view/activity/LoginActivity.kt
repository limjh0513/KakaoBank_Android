package kr.hs.dgsw.kakaobank.view.activity

import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.Observer
import kr.hs.dgsw.data.util.SharedPreferenceManager
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

            onErrorEvent.observe(this@LoginActivity, Observer {
                Toast.makeText(this@LoginActivity, "로그인에 실패했습니다.", Toast.LENGTH_SHORT).show()
            })

            onSuccessEvent.observe(this@LoginActivity, Observer {
                SharedPreferenceManager.setToken(this@LoginActivity.applicationContext, it)

                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            })
        }
    }

}