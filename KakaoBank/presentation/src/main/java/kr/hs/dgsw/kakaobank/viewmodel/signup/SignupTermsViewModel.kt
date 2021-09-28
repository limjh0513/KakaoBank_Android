package kr.hs.dgsw.kakaobank.viewmodel.signup

import androidx.lifecycle.MutableLiveData
import kr.hs.dgsw.kakaobank.base.BaseViewModel

class SignupTermsViewModel: BaseViewModel() {
    val termsIsCheck = MutableLiveData<Boolean>()
}