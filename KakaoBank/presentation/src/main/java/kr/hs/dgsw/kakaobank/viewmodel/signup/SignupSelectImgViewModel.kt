package kr.hs.dgsw.kakaobank.viewmodel.signup

import android.view.View
import kr.hs.dgsw.kakaobank.base.BaseViewModel
import kr.hs.dgsw.kakaobank.widget.SingleLiveEvent

class SignupSelectImgViewModel: BaseViewModel() {
    val imageSelectBtn = SingleLiveEvent<Any>()
    val nextBtn = SingleLiveEvent<Any>()

    fun onClickImageSelectBtn(){
        imageSelectBtn.call()
    }

    fun onClickNextBtn(){
        nextBtn.call()
    }
}