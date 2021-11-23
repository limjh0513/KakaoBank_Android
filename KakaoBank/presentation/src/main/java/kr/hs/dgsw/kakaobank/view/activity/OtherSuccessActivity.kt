package kr.hs.dgsw.kakaobank.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import kr.hs.dgsw.domain.model.OtherAccount
import kr.hs.dgsw.kakaobank.R
import kr.hs.dgsw.kakaobank.base.BaseActivity
import kr.hs.dgsw.kakaobank.databinding.ActivityOtherSuccessBinding
import kr.hs.dgsw.kakaobank.widget.adapter.OtherSelectItemAdapter

class OtherSuccessActivity : AppCompatActivity() {

    lateinit var mBinding: ActivityOtherSuccessBinding
    private lateinit var items: List<OtherAccount>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_other_success)

        items = intent.getSerializableExtra("postResultList") as List<OtherAccount>

        Log.e("adsf", items.size.toString())
        if (items.size > 0) {
            Log.e("adsf", items[0].accountNumber)
        }

        val otherSelectItemAdapter = OtherSelectItemAdapter()
        otherSelectItemAdapter.items = items
        otherSelectItemAdapter.context = this

        mBinding.otherSuccessRecycler.adapter = otherSelectItemAdapter

        mBinding.successBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            finish()
        }
    }
}