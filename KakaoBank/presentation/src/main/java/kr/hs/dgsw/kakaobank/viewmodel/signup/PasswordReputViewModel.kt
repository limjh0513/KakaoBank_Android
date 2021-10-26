package kr.hs.dgsw.kakaobank.viewmodel.signup

import android.util.Log
import androidx.lifecycle.MutableLiveData
import io.reactivex.observers.DisposableCompletableObserver
import kr.hs.dgsw.domain.request.RegisterRequest
import kr.hs.dgsw.domain.usecase.auth.RegisterUseCase
import kr.hs.dgsw.kakaobank.base.BaseViewModel
import kr.hs.dgsw.kakaobank.widget.SingleLiveEvent
import okhttp3.MultipartBody

class PasswordReputViewModel(
    private val registerUseCase: RegisterUseCase
) : BaseViewModel() {
    val password = MutableLiveData<String>()
    val passwordBackBtn = SingleLiveEvent<Any>()

    val onSuccessEvent = SingleLiveEvent<Unit>()
    val onErrorEvent = SingleLiveEvent<Throwable>()

    val userName = MutableLiveData<String>()

    init {
        userName.value = ""
        password.value = ""
    }

    fun onClickPasswordBtn(number: Int) {
        password.value += "$number"
        Log.e("password", "${password.value}")
    }

    fun onClickBackBtn() {
        passwordBackBtn.call()
    }

    fun signUp(request: RegisterRequest, file: MultipartBody.Part?) {
        addDisposable(registerUseCase.buildUseCaseObservable(RegisterUseCase.Params(
            request.id!!,
            request.name!!,
            request.nickName!!,
            request.password!!,
            request.phoneNumber!!,
            request.residentRegistrationNumber!!,
            request.simpleNumber!!,
            file),), object : DisposableCompletableObserver() {
            override fun onComplete() {
                onSuccessEvent.call()
                userName.value = request.name
            }

            override fun onError(e: Throwable) {
                onErrorEvent.value = e
                e.printStackTrace()
            }

        })
    }
}