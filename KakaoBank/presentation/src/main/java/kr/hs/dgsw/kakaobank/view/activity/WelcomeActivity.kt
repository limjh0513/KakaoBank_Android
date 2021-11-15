package kr.hs.dgsw.kakaobank.view.activity

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import kr.hs.dgsw.kakaobank.R
import kr.hs.dgsw.kakaobank.databinding.ActivityWelcomBinding

class WelcomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityWelcomBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_welcom)

        Log.e("asdffasd", intent.getStringExtra("userName").toString())
        binding.welcomTvName.text = "반가워요 ${intent.getStringExtra("userName")}님!"

        binding.button2.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}