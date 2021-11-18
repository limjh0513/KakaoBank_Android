package kr.hs.dgsw.kakaobank.viewmodel.other

import androidx.lifecycle.MutableLiveData
import io.reactivex.observers.DisposableSingleObserver
import kr.hs.dgsw.domain.model.Account
import kr.hs.dgsw.domain.usecase.account.GetOtherBankAccount
import kr.hs.dgsw.kakaobank.base.BaseViewModel

class OtherSelectViewModel(private val getOtherBankAccountUseCase: GetOtherBankAccount) :
    BaseViewModel() {
    val selectList = MutableLiveData<List<Account>>()

    val otherBankList = MutableLiveData<List<Account>>()
    val onErrorEvent = MutableLiveData<Throwable>()

    fun getOtherBankAccount(token: String) {
        addDisposable(getOtherBankAccountUseCase.buildUseCaseObservable(GetOtherBankAccount.Params(
            token)), object : DisposableSingleObserver<List<Account>>(){
            override fun onSuccess(t: List<Account>) {
                otherBankList.value = t
            }

            override fun onError(e: Throwable) {
                onErrorEvent.value = e
            }

        })
    }

}