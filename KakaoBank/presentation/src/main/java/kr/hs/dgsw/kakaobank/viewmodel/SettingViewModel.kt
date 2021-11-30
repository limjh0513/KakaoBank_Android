package kr.hs.dgsw.kakaobank.viewmodel

import androidx.lifecycle.MutableLiveData
import kr.hs.dgsw.kakaobank.base.BaseViewModel
import kr.hs.dgsw.kakaobank.widget.SingleLiveEvent

class SettingViewModel : BaseViewModel() {
    val modeSwitch = MutableLiveData<Boolean>()
    val backBtn = SingleLiveEvent<Any>()


    fun onClickBackBtn() {
        backBtn.call()
    }
}