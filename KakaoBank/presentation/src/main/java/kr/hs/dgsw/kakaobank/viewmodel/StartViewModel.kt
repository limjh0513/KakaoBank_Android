package kr.hs.dgsw.kakaobank.viewmodel

import android.view.View
import kr.hs.dgsw.kakaobank.base.BaseViewModel
import kr.hs.dgsw.kakaobank.widget.SingleLiveEvent

class StartViewModel : BaseViewModel() {
    val onClickSignUpBtn = SingleLiveEvent<Any>()
    val onClickSignInBtn = SingleLiveEvent<Any>()

    fun onClicksSignUp() {
        onClickSignUpBtn.call()
    }

    fun onClickSignIn() {
        onClickSignInBtn.call()
    }

}