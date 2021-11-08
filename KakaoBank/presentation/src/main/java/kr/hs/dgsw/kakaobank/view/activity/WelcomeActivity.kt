package kr.hs.dgsw.kakaobank.view.activity

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import kr.hs.dgsw.kakaobank.R
import kr.hs.dgsw.kakaobank.databinding.ActivityWelcomBinding

class WelcomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityWelcomBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_welcom)

        binding.welcomTvName.text = "반가워요 ${intent.getStringExtra("name")}님!"
        binding.welcomProfileImg.setImageBitmap(intent.getParcelableExtra("image"))
    }
}