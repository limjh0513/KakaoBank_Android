package kr.hs.dgsw.kakaobank.viewmodel.transfer

import android.util.Log
import androidx.lifecycle.MutableLiveData
import kr.hs.dgsw.kakaobank.base.BaseViewModel
import kr.hs.dgsw.kakaobank.widget.SingleLiveEvent

class TransferInputViewModel: BaseViewModel() {
    val cancelBtn = SingleLiveEvent<Any>()
    val backBtn = SingleLiveEvent<Any>()
    val bankBookNumber = MutableLiveData<String>()

    init {
        bankBookNumber.value = "";
    }

    fun onClickCancelBtn(){
        cancelBtn.call()
    }

    fun onClickNumberBtn(number: Int){
        bankBookNumber.value += "$number"
    }

    fun onClickBackBtn(){
        backBtn.call()
    }
}