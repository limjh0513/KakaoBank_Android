package kr.hs.dgsw.kakaobank.viewmodel

import androidx.lifecycle.MutableLiveData
import io.reactivex.observers.DisposableSingleObserver
import kr.hs.dgsw.domain.model.Account
import kr.hs.dgsw.domain.usecase.account.GetAccountUseCase
import kr.hs.dgsw.kakaobank.base.BaseViewModel
import kr.hs.dgsw.kakaobank.widget.SingleLiveEvent

class MainViewModel(private val getAccountUseCase: GetAccountUseCase) : BaseViewModel() {
    val userName = MutableLiveData<String>()
    val openUpBtn = SingleLiveEvent<Any>()
    val accountList = MutableLiveData<List<Account>>()
    val getErrorEvent = MutableLiveData<Throwable>()

    fun getAccountList(token: String) {
        addDisposable(getAccountUseCase.buildUseCaseObservable(GetAccountUseCase.Params(token)),
            object : DisposableSingleObserver<List<Account>>() {
                override fun onSuccess(t: List<Account>) {
                    accountList.value = t
                }

                override fun onError(e: Throwable) {
                    getErrorEvent.value = e
                    e.printStackTrace()
                }

            })
    }

    fun onClickOpenUpBtn() {
        openUpBtn.call()
    }
}