package kr.hs.dgsw.kakaobank.view.activity

import android.content.Intent
import androidx.lifecycle.Observer
import kr.hs.dgsw.kakaobank.R
import kr.hs.dgsw.kakaobank.base.BaseActivity
import kr.hs.dgsw.kakaobank.databinding.ActivityStartBinding
import kr.hs.dgsw.kakaobank.viewmodel.StartViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.getViewModel

class StartActivity : BaseActivity<ActivityStartBinding, StartViewModel>() {
    override val layoutRes: Int
        get() = R.layout.activity_start

    override val viewModel: StartViewModel by inject()

    override fun observerViewModel() {
        with(viewModel) {
            onClickSignInBtn.observe(this@StartActivity, Observer {

            })

            onClickSignUpBtn.observe(this@StartActivity, Observer {
                val intent = Intent(this@StartActivity, SignupActivity::class.java)
                startActivity(intent)
            })
        }
    }
}