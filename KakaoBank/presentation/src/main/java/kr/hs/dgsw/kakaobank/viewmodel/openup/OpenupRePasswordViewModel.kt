package kr.hs.dgsw.kakaobank.viewmodel.openup

import android.util.Log
import androidx.lifecycle.MutableLiveData
import io.reactivex.observers.DisposableCompletableObserver
import kr.hs.dgsw.domain.request.AccountRequest
import kr.hs.dgsw.domain.usecase.account.InsertAccountUseCase
import kr.hs.dgsw.kakaobank.base.BaseViewModel
import kr.hs.dgsw.kakaobank.widget.SingleLiveEvent

class OpenupRePasswordViewModel(
    private val insertAccountUseCase: InsertAccountUseCase
): BaseViewModel() {
    val password = MutableLiveData<String>()
    val passwordBackBtn = SingleLiveEvent<Any>()

    val insertSuccess = SingleLiveEvent<Unit>()
    val insertFail = SingleLiveEvent<Throwable>()

    init {
        password.value = ""
    }

    fun insertAccount(token: String, request: AccountRequest){
        addDisposable(insertAccountUseCase.buildUseCaseObservable(InsertAccountUseCase.Params(token, request)), object: DisposableCompletableObserver(){
            override fun onComplete() {
                insertSuccess.call()
            }

            override fun onError(e: Throwable) {
                insertFail.value = e
                e.printStackTrace()
            }

        })
    }

    fun onClickPasswordBtn(number: Int) {
        password.value += "$number"
    }

    fun onClickBackBtn() {
        passwordBackBtn.call()
    }
}