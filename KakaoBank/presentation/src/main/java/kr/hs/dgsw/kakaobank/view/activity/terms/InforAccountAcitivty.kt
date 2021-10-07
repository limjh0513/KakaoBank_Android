package kr.hs.dgsw.kakaobank.view.activity.terms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import kr.hs.dgsw.kakaobank.R
import kr.hs.dgsw.kakaobank.databinding.ActivityInforAccountBinding

class InforAccountAcitivty : AppCompatActivity() {

    lateinit var mBinding: ActivityInforAccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_infor_account)

        mBinding.inforABackBtn.setOnClickListener {
            finish()
        }
    }
}