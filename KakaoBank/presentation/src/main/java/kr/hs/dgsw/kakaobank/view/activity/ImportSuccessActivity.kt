package kr.hs.dgsw.kakaobank.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kr.hs.dgsw.kakaobank.R

class ImportSuccessActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_import_success)

        val button = findViewById<Button>(R.id.import_okButton)
        button.setOnClickListener {
            finish()
        }
    }
}