package kr.hs.dgsw.kakaobank.view.activity

import kr.hs.dgsw.domain.request.TransferRequest
import kr.hs.dgsw.kakaobank.R
import kr.hs.dgsw.kakaobank.base.BaseActivity
import kr.hs.dgsw.kakaobank.databinding.ActivityTransferBinding
import kr.hs.dgsw.kakaobank.viewmodel.TransferViewModel
import org.koin.android.ext.android.inject

class TransferActivity : BaseActivity<ActivityTransferBinding, TransferViewModel>() {
    override val mViewModel: TransferViewModel by inject()
    override val layoutRes: Int
        get() = R.layout.activity_transfer

    var request: TransferRequest = TransferRequest()
    var bank: String = ""
    var money: Int = 0
    var accountName: String = ""
    var fees: Int = 0

    override fun observerViewModel() {
        getFromAccountNumber()

        with(mViewModel) {

        }
    }

    private fun getFromAccountNumber() {
        request.fromAccountNumber =
            intent.getStringExtra("number")
        money = intent.getIntExtra("money", 0)
        accountName = intent.getStringExtra("name").toString()
    }
}