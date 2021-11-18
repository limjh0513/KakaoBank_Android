package kr.hs.dgsw.kakaobank.view.activity

import android.content.Intent
import androidx.lifecycle.Observer
import kr.hs.dgsw.data.util.SharedPreferenceManager
import kr.hs.dgsw.kakaobank.R
import kr.hs.dgsw.kakaobank.base.BaseActivity
import kr.hs.dgsw.kakaobank.databinding.ActivityStartBinding
import kr.hs.dgsw.kakaobank.viewmodel.StartViewModel
import org.koin.android.ext.android.inject

class StartActivity : BaseActivity<ActivityStartBinding, StartViewModel>() {
    override val layoutRes: Int
        get() = R.layout.activity_start

    override val mViewModel: StartViewModel by inject()

    override fun observerViewModel() {

        with(mViewModel) {
            onClickSignInBtn.observe(this@StartActivity, Observer{
                if(SharedPreferenceManager.getToken(this@StartActivity).equals(null)){
                    val intent = Intent(this@StartActivity, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    val intent = Intent(this@StartActivity, EasyLoginActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            })

            onClickSignUpBtn.observe(this@StartActivity, Observer {
                val intent = Intent(this@StartActivity, SignupActivity::class.java)
                startActivity(intent)
            })
        }
    }
}