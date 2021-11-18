package kr.hs.dgsw.kakaobank.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import kr.hs.dgsw.kakaobank.R
import kr.hs.dgsw.kakaobank.base.BaseActivity
import kr.hs.dgsw.kakaobank.databinding.ActivityOtherBinding
import kr.hs.dgsw.kakaobank.viewmodel.OtherViewModel
import org.koin.android.ext.android.inject

class OtherActivity : BaseActivity<ActivityOtherBinding, OtherViewModel>() {
    override val mViewModel: OtherViewModel by inject()
    override val layoutRes: Int
        get() = R.layout.activity_other

    override fun observerViewModel() {
        with(mViewModel){
            cancelBtn.observe(this@OtherActivity, Observer {
                finish()
            })
        }
    }

}