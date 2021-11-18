package kr.hs.dgsw.kakaobank.viewmodel

import kr.hs.dgsw.kakaobank.base.BaseViewModel
import kr.hs.dgsw.kakaobank.widget.SingleLiveEvent

class OtherViewModel:BaseViewModel() {
    val cancelBtn = SingleLiveEvent<Any>()

    fun onClickCancelBtn(){
        cancelBtn.call()
    }
}