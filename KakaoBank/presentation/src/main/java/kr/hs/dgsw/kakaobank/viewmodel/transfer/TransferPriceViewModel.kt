package kr.hs.dgsw.kakaobank.viewmodel.transfer

import androidx.lifecycle.MutableLiveData
import kr.hs.dgsw.kakaobank.base.BaseViewModel
import kr.hs.dgsw.kakaobank.widget.SingleLiveEvent

class TransferPriceViewModel: BaseViewModel() {
    val cancelBtn = SingleLiveEvent<Any>()
    val backBtn = SingleLiveEvent<Any>()
    val transferMoney = MutableLiveData<String>()

    init{
        transferMoney.value = ""
    }

    fun onClickCancelBtn(){
        cancelBtn.call()
    }

    fun onClickNumberBtn(number: Int){
        transferMoney.value += "$number"
    }

    fun onClickBackBtn(){
        backBtn.call()
    }
}