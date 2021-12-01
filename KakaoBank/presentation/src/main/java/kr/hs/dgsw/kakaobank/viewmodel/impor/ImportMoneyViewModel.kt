package kr.hs.dgsw.kakaobank.viewmodel.impor

import androidx.lifecycle.MutableLiveData
import kr.hs.dgsw.kakaobank.base.BaseViewModel
import kr.hs.dgsw.kakaobank.widget.SingleLiveEvent

class ImportMoneyViewModel : BaseViewModel() {
    val cancelBtn = SingleLiveEvent<Any>()
    val backBtn = SingleLiveEvent<Any>()
    val importMoney = MutableLiveData<String>()
    val bankSubmitBtn = SingleLiveEvent<Any>()

    init {
        importMoney.value = "";
    }

    fun onClickbankSubmitBtn(){
        bankSubmitBtn.call()
    }

    fun onClickCancelBtn(){
        cancelBtn.call()
    }

    fun onClickNumberBtn(number: Int){
        importMoney.value = "${importMoney.value}${number}"
    }

    fun onClickBackBtn(){
        backBtn.call()
    }
}