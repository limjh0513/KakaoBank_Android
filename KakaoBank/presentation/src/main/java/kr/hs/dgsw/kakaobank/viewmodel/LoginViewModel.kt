package kr.hs.dgsw.kakaobank.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import io.reactivex.observers.DisposableSingleObserver
import kr.hs.dgsw.data.network.response.LoginData
import kr.hs.dgsw.domain.usecase.auth.LoginUseCase
import kr.hs.dgsw.kakaobank.base.BaseViewModel
import kr.hs.dgsw.kakaobank.widget.SingleLiveEvent

class LoginViewModel(private val loginUseCase: LoginUseCase) : BaseViewModel() {
    val inputId = MutableLiveData<String>()
    val inputPw = MutableLiveData<String>()
    val loginBtn = SingleLiveEvent<Any>()
    val backBtn = SingleLiveEvent<Any>()

    val onSuccessEvent = MutableLiveData<String>()
    val onErrorEvent = MutableLiveData<Throwable>()

    fun onClickLoginBtn() {
        if(inputId.value != null && inputPw.value!=null){
            addDisposable(loginUseCase.buildUseCaseObservable(LoginUseCase.Params(inputId.value!!,
                inputPw.value!!)), object: DisposableSingleObserver<String>(){
                override fun onSuccess(t: String) {
                    onSuccessEvent.value = t
                    Log.e("1235126", t)
                }

                override fun onError(e: Throwable) {
                    onErrorEvent.value = e
                }

            })
        }
    }

    fun onClickBackBtn() {
        backBtn.call()
    }
}