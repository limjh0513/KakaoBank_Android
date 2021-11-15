package kr.hs.dgsw.kakaobank.viewmodel.openup

import android.util.Log
import androidx.lifecycle.MutableLiveData
import kr.hs.dgsw.kakaobank.base.BaseViewModel
import kr.hs.dgsw.kakaobank.widget.SingleLiveEvent

class OpenupPasswordViewModel: BaseViewModel() {
    val password = MutableLiveData<String>()
    val passwordBackBtn = SingleLiveEvent<Any>()

    init {
        password.value = ""
    }

    fun onClickPasswordBtn(number: Int) {
        password.value += "$number"
    }

    fun onClickBackBtn() {
        passwordBackBtn.call()
    }
}