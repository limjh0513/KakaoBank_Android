package kr.hs.dgsw.kakaobank.viewmodel.openup

import androidx.lifecycle.MutableLiveData
import kr.hs.dgsw.kakaobank.base.BaseViewModel

class BankBookNickViewModel : BaseViewModel() {
    val bankBookNickName = MutableLiveData<String>()

    val showName = MutableLiveData<String>()
    val showResist = MutableLiveData<String>()

}