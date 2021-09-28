package kr.hs.dgsw.kakaobank.viewmodel.signup

import android.view.View
import androidx.lifecycle.MutableLiveData
import kr.hs.dgsw.kakaobank.base.BaseViewModel
import kr.hs.dgsw.kakaobank.widget.SingleLiveEvent

class SignupInputViewModel: BaseViewModel() {
    val inputId = MutableLiveData<String>()
    val overlapCheckBtn = SingleLiveEvent<Any>()
    val inputPw = MutableLiveData<String>()
    val inputPwAgain = MutableLiveData<String>()
    val inputName = MutableLiveData<String>()
    val residentFrontNumber = MutableLiveData<String>()
    val residentBackNumber = MutableLiveData<String>()
    val inputPhoneNumber = MutableLiveData<String>()
    val inputNickName = MutableLiveData<String>()

    fun onClickOverlapCheckBtn(){
        overlapCheckBtn.call()
    }
}