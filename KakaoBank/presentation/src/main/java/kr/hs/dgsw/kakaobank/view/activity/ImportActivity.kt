package kr.hs.dgsw.kakaobank.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.hs.dgsw.kakaobank.R
import kr.hs.dgsw.kakaobank.base.BaseActivity
import kr.hs.dgsw.kakaobank.databinding.ActivityImportBinding
import kr.hs.dgsw.kakaobank.viewmodel.ImportViewModel
import org.koin.android.ext.android.inject

class ImportActivity : BaseActivity<ActivityImportBinding, ImportViewModel>() {
    override val mViewModel: ImportViewModel by inject()
    override val layoutRes: Int
        get() = R.layout.activity_import

    lateinit var accountNumber: String
    var importAccountNumber: String? = null

    override fun observerViewModel() {
        getAccountNumber()

        with(mViewModel) {

        }
    }

    private fun getAccountNumber() {
        accountNumber = intent.getStringExtra("accountNumber").toString()
    }
}