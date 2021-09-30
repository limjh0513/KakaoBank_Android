package kr.hs.dgsw.kakaobank.viewmodel

import androidx.lifecycle.MutableLiveData
import kr.hs.dgsw.kakaobank.base.BaseViewModel
import kr.hs.dgsw.kakaobank.widget.SingleLiveEvent

class LoginViewModel: BaseViewModel() {
    val inputId = MutableLiveData<String>()
    val inputPw = MutableLiveData<String>()
    val loginBtn = SingleLiveEvent<Any>()
    val backBtn = SingleLiveEvent<Any>()

    fun onClickLoginBtn(){
        loginBtn.call()
    }

    fun onClickBackBtn(){
        backBtn.call()
    }
}