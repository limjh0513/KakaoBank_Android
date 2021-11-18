package kr.hs.dgsw.kakaobank.viewmodel.other

import androidx.lifecycle.MutableLiveData
import kr.hs.dgsw.kakaobank.base.BaseViewModel
import kr.hs.dgsw.kakaobank.widget.SingleLiveEvent

class OtherTermsViewModel: BaseViewModel() {
    val isChecked = MutableLiveData<Boolean>()
    val termsShowBtn = SingleLiveEvent<Any>()

    fun onClickTermsShowBtn(){
        termsShowBtn.call()
    }
}