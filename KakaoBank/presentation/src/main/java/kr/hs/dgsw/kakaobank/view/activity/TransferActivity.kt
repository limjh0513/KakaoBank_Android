package kr.hs.dgsw.kakaobank.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.hs.dgsw.kakaobank.R
import kr.hs.dgsw.kakaobank.base.BaseActivity
import kr.hs.dgsw.kakaobank.databinding.ActivityTransferBinding
import kr.hs.dgsw.kakaobank.viewmodel.TransferViewModel
import org.koin.android.ext.android.inject

class TransferActivity : BaseActivity<ActivityTransferBinding, TransferViewModel>() {
    override val mViewModel: TransferViewModel by inject()
    override val layoutRes: Int
        get() = R.layout.activity_transfer

    override fun observerViewModel() {
        with(mViewModel){

        }
    }
}