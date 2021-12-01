package kr.hs.dgsw.kakaobank.viewmodel.impor

import androidx.lifecycle.MutableLiveData
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.observers.DisposableSingleObserver
import kr.hs.dgsw.domain.request.ImportRequest
import kr.hs.dgsw.domain.request.TransferRequest
import kr.hs.dgsw.domain.usecase.account.ImportMoneyUseCase
import kr.hs.dgsw.domain.usecase.account.PasswordCheckUseCase
import kr.hs.dgsw.domain.usecase.account.TransferMoneyUseCase
import kr.hs.dgsw.kakaobank.base.BaseViewModel
import kr.hs.dgsw.kakaobank.widget.SingleLiveEvent

class ImportPasswordViewModel(private val passwordCheckUseCase: PasswordCheckUseCase, private val importMoneyUseCase: ImportMoneyUseCase) : BaseViewModel() {

    val cancelBtn = SingleLiveEvent<Any>()
    val backBtn = SingleLiveEvent<Any>()
    val password = MutableLiveData<String>()

    val loginSuccess = MutableLiveData<Boolean>()
    val loginError = MutableLiveData<Throwable>()

    val importMoneySuccess = SingleLiveEvent<Any>()
    val importMoneyError = MutableLiveData<Throwable>()

    fun passwordCheck(token: String, accountNumber: String, password: String){
        addDisposable(passwordCheckUseCase.buildUseCaseObservable(PasswordCheckUseCase.Params(token, accountNumber, password)), object : DisposableSingleObserver<Boolean>(){
            override fun onSuccess(t: Boolean) {
                loginSuccess.value = t
            }

            override fun onError(e: Throwable) {
                loginError.value = e
                e.printStackTrace()
            }

        })
    }

    fun importMoney(token:String, request: ImportRequest){
        addDisposable(importMoneyUseCase.buildUseCaseObservable(ImportMoneyUseCase.Params(token, request)), object : DisposableCompletableObserver(){
            override fun onComplete() {
                importMoneySuccess.call()
            }

            override fun onError(e: Throwable) {
                importMoneyError.value = e
                e.printStackTrace()
            }

        })
    }


    fun onClickCancelBtn() {
        cancelBtn.call()
    }

    fun onClickNumberBtn(number: Int) {
        password.value = "${password.value}${number}"
    }

    fun onClickBackBtn() {
        backBtn.call()
    }
}