package kr.hs.dgsw.kakaobank.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.hs.dgsw.domain.request.ImportRequest
import kr.hs.dgsw.kakaobank.R
import kr.hs.dgsw.kakaobank.base.BaseActivity
import kr.hs.dgsw.kakaobank.databinding.ActivityImportBinding
import kr.hs.dgsw.kakaobank.viewmodel.ImportViewModel
import org.koin.android.ext.android.inject

class ImportActivity : BaseActivity<ActivityImportBinding, ImportViewModel>() {
    override val mViewModel: ImportViewModel by inject()
    override val layoutRes: Int
        get() = R.layout.activity_import

    var request = ImportRequest()
    var toNickName: String = ""
    var fromNickName: String = ""
    var fromMoney: Int = 0

    override fun observerViewModel() {
        getAccountNumber()

        with(mViewModel) {

        }
    }

    private fun getAccountNumber() {
        request.toAccountNum = intent.getStringExtra("accountNumber").toString()
        toNickName = intent.getStringExtra("name").toString()
    }
}