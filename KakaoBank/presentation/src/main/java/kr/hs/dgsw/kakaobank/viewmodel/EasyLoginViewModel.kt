package kr.hs.dgsw.kakaobank.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import io.reactivex.observers.DisposableCompletableObserver
import kr.hs.dgsw.domain.usecase.auth.EasyLoginUseCase
import kr.hs.dgsw.kakaobank.base.BaseViewModel
import kr.hs.dgsw.kakaobank.widget.SingleLiveEvent

class EasyLoginViewModel(private val easyLoginUseCase: EasyLoginUseCase) : BaseViewModel() {
    val backBtn = SingleLiveEvent<Any>()
    val password = MutableLiveData<String>()
    val passwordBackBtn = SingleLiveEvent<Any>()

    val easyLoginSuccess = SingleLiveEvent<Any>()
    val easyLoginFail = SingleLiveEvent<Throwable>()

    init {
        password.value = ""
    }

    fun easyLogin(token: String, password: Int){
        addDisposable(easyLoginUseCase.buildUseCaseObservable(EasyLoginUseCase.Params(token, password)), object: DisposableCompletableObserver(){
            override fun onComplete() {
                easyLoginSuccess.call()
            }

            override fun onError(e: Throwable) {
                easyLoginFail.value = e
                e.printStackTrace()
            }

        })
    }

    fun onClickBackBtn(){
        backBtn.call()
    }

    fun onClickPasswordBtn(number: Int){
        password.value += "$number"
        Log.e("password", "${password.value}")
    }

    fun onClickPasswordBackBtn(){
        passwordBackBtn.call()
    }
}