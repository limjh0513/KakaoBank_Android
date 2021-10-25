package kr.hs.dgsw.kakaobank.viewmodel.signup

import android.app.Application
import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.observers.DisposableSingleObserver
import kr.hs.dgsw.domain.request.RegisterRequest
import kr.hs.dgsw.domain.usecase.auth.IdAvailableUseCase
import kr.hs.dgsw.domain.usecase.auth.LoginUseCase
import kr.hs.dgsw.domain.usecase.auth.RegisterUseCase
import kr.hs.dgsw.kakaobank.base.BaseViewModel
import kr.hs.dgsw.kakaobank.widget.SingleLiveEvent

class SignupInputViewModel(
    private val idAvailableUseCase: IdAvailableUseCase,
) : BaseViewModel() {


    val inputId = MutableLiveData<String>()
    val overlapCheckBtn = SingleLiveEvent<Any>()
    val inputPw = MutableLiveData<String>()
    val inputPwAgain = MutableLiveData<String>()
    val inputName = MutableLiveData<String>()
    val residentFrontNumber = MutableLiveData<String>()
    val residentBackNumber = MutableLiveData<String>()
    val inputPhoneNumber = MutableLiveData<String>()
    val inputNickName = MutableLiveData<String>()

    val onAvailableErrorEvent = SingleLiveEvent<Throwable>()
    val onAvailableSuccessEvent = MutableLiveData<Boolean>()

    fun onClickOverlapCheckBtn() {
        overlapCheckBtn.call()
    }

    fun checkAvailableId() {
        addDisposable(idAvailableUseCase.buildUseCaseObservable(IdAvailableUseCase.Params(inputId.value!!)),
            object : DisposableSingleObserver<Boolean>() {
                override fun onSuccess(t: Boolean) {
                    Log.e("12213", "${t}")
                    onAvailableSuccessEvent.value = t
                }

                override fun onError(e: Throwable) {
                    onAvailableErrorEvent.value = e
                    e.printStackTrace()
                }
            })
    }


}