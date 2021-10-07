package kr.hs.dgsw.kakaobank.viewmodel.openup

import androidx.lifecycle.MutableLiveData
import kr.hs.dgsw.kakaobank.base.BaseViewModel
import kr.hs.dgsw.kakaobank.widget.SingleLiveEvent

class OpenupTermsViewModel: BaseViewModel() {
    val termsMainIsChecked = MutableLiveData<Boolean>()
    val termsIsChecked1 = MutableLiveData<Boolean>()
    val termsIsChecked2 = MutableLiveData<Boolean>()

    val termsMainShowBtn = SingleLiveEvent<Any>()
    val termsShowBtn1 = SingleLiveEvent<Any>()
    val termsShowBtn2 = SingleLiveEvent<Any>()

    fun onClickTermsMainShowBtn(){
        termsMainShowBtn.call()
    }

    fun onClickTermsShowBtn1(){
        termsShowBtn1.call()
    }

    fun onClickTermsShowBtn2(){
        termsShowBtn2.call()
    }
}