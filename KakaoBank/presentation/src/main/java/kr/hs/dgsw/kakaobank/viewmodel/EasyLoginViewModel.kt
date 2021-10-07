package kr.hs.dgsw.kakaobank.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import kr.hs.dgsw.kakaobank.base.BaseViewModel
import kr.hs.dgsw.kakaobank.widget.SingleLiveEvent

class EasyLoginViewModel : BaseViewModel() {
    val backBtn = SingleLiveEvent<Any>()
    val password = MutableLiveData<String>()
    val passwordBackBtn = SingleLiveEvent<Any>()

    init {
        password.value = ""
    }

    fun onClickBackBtn(){
        backBtn.call()
    }

    fun onClickPasswordBtn(number: Int){
        password.value += "$number"
        Log.e("password", "${password.value}")
    }

    fun onClickPasswordBackBtn(){
        passwordBackBtn.call()
    }
}