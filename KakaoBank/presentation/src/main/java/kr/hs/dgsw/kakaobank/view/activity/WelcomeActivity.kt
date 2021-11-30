package kr.hs.dgsw.kakaobank.view.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import kr.hs.dgsw.data.util.SharedPreferenceManager
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

        getCurrentMode()
    }

    private fun getCurrentMode() {
        if (SharedPreferenceManager.getMode(this) == null) {
            val currentMode = AppCompatDelegate.getDefaultNightMode()
            if (currentMode == AppCompatDelegate.MODE_NIGHT_YES) {
                SharedPreferenceManager.setMode(this, true)
            } else if (currentMode == AppCompatDelegate.MODE_NIGHT_NO) {
                SharedPreferenceManager.setMode(this, false)
            }
        } else {
            if(SharedPreferenceManager.getMode(this).equals("dark")){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else if(SharedPreferenceManager.getMode(this).equals("light")) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
    }
}