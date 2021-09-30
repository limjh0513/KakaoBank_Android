package kr.hs.dgsw.kakaobank.viewmodel

import kr.hs.dgsw.kakaobank.base.BaseViewModel
import kr.hs.dgsw.kakaobank.widget.SingleLiveEvent

class SignupViewModel: BaseViewModel() {
    val cancelBtn = SingleLiveEvent<Any>()

    fun onClickCancelBtn(){
        cancelBtn.call()
    }
}