package kr.hs.dgsw.kakaobank.viewmodel.transfer

import kr.hs.dgsw.kakaobank.base.BaseViewModel
import kr.hs.dgsw.kakaobank.widget.SingleLiveEvent

class TransferBankViewModel: BaseViewModel() {

    val backBtn = SingleLiveEvent<Any>()

    val kakaoBankBtn = SingleLiveEvent<Any>()
    val tossBankBtn = SingleLiveEvent<Any>()
    val deaguBankBtn = SingleLiveEvent<Any>()
    val kBankBtn = SingleLiveEvent<Any>()
    val magguBtn = SingleLiveEvent<Any>()

    fun onClickKakaoBankBtn(){
        kakaoBankBtn.call()
    }

    fun onClickTossBankBtn(){
        tossBankBtn.call()
    }

    fun onClickDeaguBankBtn(){
        deaguBankBtn.call()
    }

    fun onClickKBankBtn(){
        kBankBtn.call()
    }

    fun onClickMaaguBankBtn(){
        magguBtn.call()
    }

    fun onClickBackBtn(){
        backBtn.call()
    }
}