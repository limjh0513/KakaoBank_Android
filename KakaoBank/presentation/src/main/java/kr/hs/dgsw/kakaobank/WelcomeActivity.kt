package kr.hs.dgsw.kakaobank

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import kr.hs.dgsw.kakaobank.databinding.ActivityWelcomBinding

class WelcomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityWelcomBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_welcom)
    }
}