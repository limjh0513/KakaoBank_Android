package kr.hs.dgsw.kakaobank.viewmodel.signup

import androidx.lifecycle.MutableLiveData
import kr.hs.dgsw.kakaobank.base.BaseViewModel
import kr.hs.dgsw.kakaobank.widget.SingleLiveEvent

class SignupTermsViewModel: BaseViewModel() {
    val termsIsCheck = MutableLiveData<Boolean>()

    val firstPolicy = SingleLiveEvent<Any>()
    val secondPolicy = SingleLiveEvent<Any>()

    fun onClickFirstPolicy(){
        firstPolicy.call()
    }

    fun onClickSecondPolicy(){
        secondPolicy.call()
    }
}