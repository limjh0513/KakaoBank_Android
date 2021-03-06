package kr.hs.dgsw.kakaobank.view.activity

import androidx.lifecycle.Observer
import kr.hs.dgsw.domain.request.AccountRequest
import kr.hs.dgsw.kakaobank.R
import kr.hs.dgsw.kakaobank.base.BaseActivity
import kr.hs.dgsw.kakaobank.databinding.ActivityOpenupBinding
import kr.hs.dgsw.kakaobank.viewmodel.OpenupViewModel
import org.koin.android.ext.android.inject

class OpenupActivity : BaseActivity<ActivityOpenupBinding, OpenupViewModel>() {
    override val mViewModel: OpenupViewModel by inject()
    override val layoutRes: Int
        get() = R.layout.activity_openup

    var request = AccountRequest()

    override fun observerViewModel() {
        with(mViewModel){
            cancelBtn.observe(this@OpenupActivity, Observer {
                finish()
            })
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}