package kr.hs.dgsw.kakaobank.viewmodel.other

import android.util.Log
import androidx.lifecycle.MutableLiveData
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.observers.DisposableSingleObserver
import kr.hs.dgsw.domain.model.Account
import kr.hs.dgsw.domain.model.OtherAccount
import kr.hs.dgsw.domain.request.OtherAccountRequest
import kr.hs.dgsw.domain.usecase.account.GetOtherBankUseCase
import kr.hs.dgsw.domain.usecase.account.PostOtherBankUseCase
import kr.hs.dgsw.kakaobank.base.BaseViewModel

class OtherSelectViewModel(
    private val getOtherBankAccountUseCase: GetOtherBankUseCase,
    private val postOtherBankUseCase: PostOtherBankUseCase,
) :
    BaseViewModel() {
    val selectList = MutableLiveData<List<Account>>()

    val otherBankList = MutableLiveData<List<Account>>()
    val onErrorEvent = MutableLiveData<Throwable>()

    val postOnSuccess = MutableLiveData<OtherAccount>()
    val postOnError = MutableLiveData<OtherAccount>()


    fun getOtherBankAccount(token: String) {
        addDisposable(getOtherBankAccountUseCase.buildUseCaseObservable(GetOtherBankUseCase.Params(
            token)), object : DisposableSingleObserver<List<Account>>() {
            override fun onSuccess(t: List<Account>) {
                Log.e("asdf", "${t.size} ${t}")
                otherBankList.value = t
            }

            override fun onError(e: Throwable) {
                onErrorEvent.value = e
            }

        })
    }

    fun postOtherBankAccount(token: String, request: OtherAccountRequest) {
        addDisposable(postOtherBankUseCase.buildUseCaseObservable(PostOtherBankUseCase.Params(
            token, request)), object : DisposableCompletableObserver() {
            override fun onComplete() {
                val result = OtherAccount(request.accountNumber,
                    request.bank,
                    request.money,
                    request.nickname,
                    true)
                postOnSuccess.value = result
            }

            override fun onError(e: Throwable) {
                val result = OtherAccount(request.accountNumber,
                    request.bank,
                    request.money,
                    request.nickname,
                    false)
                postOnError.value = result
                Log.e("rasdf", result.accountNumber)
            }

        })
    }

}