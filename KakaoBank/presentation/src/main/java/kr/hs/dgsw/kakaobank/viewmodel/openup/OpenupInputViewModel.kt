package kr.hs.dgsw.kakaobank.viewmodel.openup

import androidx.lifecycle.MutableLiveData
import kr.hs.dgsw.kakaobank.base.BaseViewModel

class OpenupInputViewModel: BaseViewModel() {

    val inputName = MutableLiveData<String>()
    val inputRegisterFront = MutableLiveData<String>()
    val inputRegisterBack = MutableLiveData<String>()
    val positiveRadioBtn = MutableLiveData<Boolean>()
    val negativeRadioBtn = MutableLiveData<Boolean>()
}