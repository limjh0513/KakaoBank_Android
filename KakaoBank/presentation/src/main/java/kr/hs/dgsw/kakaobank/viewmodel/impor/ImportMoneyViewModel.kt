package kr.hs.dgsw.kakaobank.viewmodel.impor

import androidx.lifecycle.MutableLiveData
import kr.hs.dgsw.kakaobank.base.BaseViewModel
import kr.hs.dgsw.kakaobank.widget.SingleLiveEvent

class ImportMoneyViewModel : BaseViewModel() {
    val cancelBtn = SingleLiveEvent<Any>()
    val backBtn = SingleLiveEvent<Any>()
    val bankBookNumber = MutableLiveData<String>()
    val bankSelectBtn = SingleLiveEvent<Any>()

    init {
        bankBookNumber.value = "";
    }

    fun onClickBankSelectBtn(){
        bankSelectBtn.call()
    }


    fun onClickCancelBtn(){
        cancelBtn.call()
    }

    fun onClickNumberBtn(number: Int){
        bankBookNumber.value = "${bankBookNumber.value}${number}"
    }

    fun onClickBackBtn(){
        backBtn.call()
    }
}