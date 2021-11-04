package kr.hs.dgsw.kakaobank.viewmodel.openup

import androidx.lifecycle.MutableLiveData
import io.reactivex.observers.DisposableSingleObserver
import kr.hs.dgsw.domain.usecase.user.CertificationUserCase
import kr.hs.dgsw.kakaobank.base.BaseViewModel
import kr.hs.dgsw.kakaobank.widget.SingleLiveEvent

class OpenupInputViewModel(private val certificationUserCase: CertificationUserCase) :
    BaseViewModel() {

    val inputName = MutableLiveData<String>()
    val inputRegisterFront = MutableLiveData<String>()
    val inputRegisterBack = MutableLiveData<String>()
    val positiveRadioBtn = MutableLiveData<Boolean>()
    val negativeRadioBtn = MutableLiveData<Boolean>()

    val certifySuccess = MutableLiveData<Boolean>()
    val certifyFail = MutableLiveData<Throwable>()

    fun startCertification(token: String) {

        val name: String = inputName.value.toString()
        val rrm = "${inputRegisterFront.value}${inputRegisterBack.value}"
        addDisposable(certificationUserCase.buildUseCaseObservable(CertificationUserCase.Params(
            "Bearer $token",
            name,
            rrm)), object : DisposableSingleObserver<Boolean>() {
            override fun onSuccess(t: Boolean) {
                certifySuccess.value = t
            }

            override fun onError(e: Throwable) {
                certifyFail.value = e
            }


        })
    }
}