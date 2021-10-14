package kr.hs.dgsw.kakaobank.viewmodel

import androidx.lifecycle.MutableLiveData
import kr.hs.dgsw.kakaobank.base.BaseViewModel
import kr.hs.dgsw.kakaobank.widget.SingleLiveEvent

class MainViewModel : BaseViewModel() {
    val userName = MutableLiveData<String>()
    val openUpBtn = SingleLiveEvent<Any>()

    fun onClickOpenUpBtn(){
        openUpBtn.call()
    }
}