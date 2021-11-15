package kr.hs.dgsw.kakaobank.viewmodel.impor

import androidx.lifecycle.MutableLiveData
import io.reactivex.observers.DisposableSingleObserver
import kr.hs.dgsw.domain.model.Account
import kr.hs.dgsw.domain.usecase.account.GetAccountUseCase
import kr.hs.dgsw.kakaobank.base.BaseViewModel
import kr.hs.dgsw.kakaobank.widget.SingleLiveEvent

class ImportSelectViewModel(private val getAccountUseCase: GetAccountUseCase): BaseViewModel() {

    val cancelBtn = SingleLiveEvent<Any>()
    val onErrorEvent = MutableLiveData<Throwable>()
    val onSuccessEvent = MutableLiveData<List<Account>>()

    fun getAccountList(token : String){
        addDisposable(getAccountUseCase.buildUseCaseObservable(GetAccountUseCase.Params(token)), object : DisposableSingleObserver<List<Account>>(){
            override fun onSuccess(t: List<Account>) {
                onSuccessEvent.value = t
            }

            override fun onError(e: Throwable) {
                onErrorEvent.value = e
            }

        })
    }

    fun onClickCancelBtn(){
        cancelBtn.call()
    }
}