package kr.hs.dgsw.kakaobank.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import java.text.SimpleDateFormat
import java.util.*

open class BaseViewModel : ViewModel() {

    private val disposable = CompositeDisposable()

    val isLoading = MutableLiveData<Boolean>(false)

    fun addDisposable(single: Single<*>, observer: DisposableSingleObserver<*>) {
        disposable.add(single.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(observer as SingleObserver<Any>) as Disposable
        )
    }

    fun addDisposable(completable: Completable, observer: DisposableCompletableObserver) {
        disposable.add(completable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribeWith(observer))
    }

    fun getIsLoading(): LiveData<Boolean> {
        return isLoading
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}