package kr.hs.dgsw.kakaobank.view.activity.terms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import kr.hs.dgsw.kakaobank.R
import kr.hs.dgsw.kakaobank.databinding.ActivityBorrowAccountBinding

class BorrowAccountActivity : AppCompatActivity() {
    lateinit var binding: ActivityBorrowAccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_borrow_account)

        binding.borrowABackBtn.setOnClickListener {
            finish()
        }
    }
}