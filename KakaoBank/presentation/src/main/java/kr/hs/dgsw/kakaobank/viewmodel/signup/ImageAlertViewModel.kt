package kr.hs.dgsw.kakaobank.viewmodel.signup

import kr.hs.dgsw.kakaobank.base.BaseViewModel
import kr.hs.dgsw.kakaobank.widget.SingleLiveEvent

class ImageAlertViewModel: BaseViewModel() {
    val negativeBtn = SingleLiveEvent<Any>()
    val positiveBtn = SingleLiveEvent<Any>()

    fun onClickNegativeBtn(){
        negativeBtn.call()
    }
    fun onClickPositiveBtn(){
        positiveBtn.call()
    }
}