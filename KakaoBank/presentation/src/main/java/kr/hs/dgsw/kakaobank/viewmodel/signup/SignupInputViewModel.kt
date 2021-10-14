package kr.hs.dgsw.kakaobank.viewmodel.signup

import android.app.Application
import android.view.View
import androidx.lifecycle.MutableLiveData
import io.reactivex.observers.DisposableCompletableObserver
import kr.hs.dgsw.domain.usecase.auth.LoginUseCase
import kr.hs.dgsw.domain.usecase.auth.RegisterUseCase
import kr.hs.dgsw.kakaobank.base.BaseViewModel
import kr.hs.dgsw.kakaobank.widget.SingleLiveEvent

class SignupInputViewModel(private val registerUseCase: RegisterUseCase) : BaseViewModel() {


    val inputId = MutableLiveData<String>()
    val overlapCheckBtn = SingleLiveEvent<Any>()
    val inputPw = MutableLiveData<String>()
    val inputPwAgain = MutableLiveData<String>()
    val inputName = MutableLiveData<String>()
    val residentFrontNumber = MutableLiveData<String>()
    val residentBackNumber = MutableLiveData<String>()
    val inputPhoneNumber = MutableLiveData<String>()
    val inputNickName = MutableLiveData<String>()

    val onSuccessEvent = SingleLiveEvent<Unit>()
    val onErrorEvent = SingleLiveEvent<Throwable>()

    fun onClickOverlapCheckBtn() {
        overlapCheckBtn.call()
    }

    fun signUp() {
        val residentNum = "${residentFrontNumber.value}${residentBackNumber.value}"
        addDisposable(registerUseCase.buildUseCaseObservable(RegisterUseCase.Params(
            inputId.value!!,
            inputName.value!!,
            inputNickName.value!!,
            inputPw.value!!,
            inputPhoneNumber.value!!,
            residentNum)), object : DisposableCompletableObserver() {
            override fun onComplete() {
                onSuccessEvent.call()
            }

            override fun onError(e: Throwable) {
                onErrorEvent.value = e
                e.printStackTrace()
            }

        })
    }
}