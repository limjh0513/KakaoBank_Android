package kr.hs.dgsw.domain.usecase.account

import io.reactivex.Completable
import io.reactivex.Single
import kr.hs.dgsw.domain.base.ParamsUseCase
import kr.hs.dgsw.domain.repository.AccountRepository
import kr.hs.dgsw.domain.request.TransferRequest

class PasswordCheckUseCase (private val repository: AccountRepository) :
    ParamsUseCase<PasswordCheckUseCase.Params, Single<Boolean>>() {

    override fun buildUseCaseObservable(params: Params): Single<Boolean> {
        return repository.checkPassword(params.token, params.accountNumber, params.password)
    }

    data class Params(
        val token: String,
        val accountNumber: String,
        val password: String,
    )
}