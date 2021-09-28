package kr.hs.dgsw.kakaobank.viewmodel

import android.view.View
import kr.hs.dgsw.kakaobank.base.BaseViewModel
import kr.hs.dgsw.kakaobank.widget.SingleLiveEvent

class SignupViewModel: BaseViewModel() {
    val cancelBtn = SingleLiveEvent<Any>()
    val initSignupFragment = SingleLiveEvent<Any>()

    init{
        initSignupFragment.call()
    }

    fun onClickCancelBtn(){
        cancelBtn.call()
    }
}