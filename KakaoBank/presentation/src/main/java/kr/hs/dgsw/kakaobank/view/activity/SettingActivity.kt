package kr.hs.dgsw.kakaobank.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.Observer
import kr.hs.dgsw.data.util.SharedPreferenceManager
import kr.hs.dgsw.kakaobank.R
import kr.hs.dgsw.kakaobank.base.BaseActivity
import kr.hs.dgsw.kakaobank.databinding.ActivitySettingBinding
import kr.hs.dgsw.kakaobank.viewmodel.SettingViewModel
import org.koin.android.ext.android.inject

class SettingActivity : BaseActivity<ActivitySettingBinding, SettingViewModel>() {
    override val mViewModel: SettingViewModel by inject()
    override val layoutRes: Int
        get() = R.layout.activity_setting

    override fun observerViewModel() {
        with(mViewModel){
            backBtn.observe(this@SettingActivity, Observer {
                finish()
            })

            modeSwitch.observe(this@SettingActivity, Observer {
                if(it){
                    SharedPreferenceManager.setMode(this@SettingActivity, true)
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                } else {
                    SharedPreferenceManager.setMode(this@SettingActivity, false)
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                }
            })
        }
    }
}