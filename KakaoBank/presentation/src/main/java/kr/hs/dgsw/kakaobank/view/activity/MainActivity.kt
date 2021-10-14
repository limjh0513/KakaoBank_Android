package kr.hs.dgsw.kakaobank.view.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import kr.hs.dgsw.kakaobank.R
import kr.hs.dgsw.kakaobank.base.BaseActivity
import kr.hs.dgsw.kakaobank.databinding.ActivityMainBinding
import kr.hs.dgsw.kakaobank.viewmodel.MainViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override val mViewModel: MainViewModel by inject()
    override val layoutRes: Int
        get() = R.layout.activity_main

    override fun observerViewModel() {


        with(mViewModel){
            openUpBtn.observe(this@MainActivity, Observer {
                val intent = Intent(this@MainActivity, OpenupActivity::class.java)
                startActivity(intent)
            })
        }
    }
}