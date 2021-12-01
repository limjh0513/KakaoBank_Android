package kr.hs.dgsw.kakaobank.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import kr.hs.dgsw.kakaobank.R
import kr.hs.dgsw.kakaobank.databinding.ActivityTransferSucceseBinding

class TransferSuccessActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityTransferSucceseBinding>(this,
            R.layout.activity_transfer_succese)

        val fromAccount = intent.getStringExtra("from")
        val toAccount = intent.getStringExtra("to")
        val money = intent.getIntExtra("money", 0)
        val fees = intent.getIntExtra("fees", 0)

        binding.transferSAccount.text = "출금 계좌 : ${fromAccount}"
        binding.transferSTvName.text = "$toAccount"
        binding.transferSTvSendPrice.text = "$money"
        binding.transferSTvfees.text = "$fees"

        binding.button.setOnClickListener {
            finish()
        }

    }
}