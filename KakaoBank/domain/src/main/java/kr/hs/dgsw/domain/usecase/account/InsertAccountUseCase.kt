package kr.hs.dgsw.domain.usecase.account

import io.reactivex.Completable
import io.reactivex.Single
import kr.hs.dgsw.domain.base.ParamsUseCase
import kr.hs.dgsw.domain.model.Account
import kr.hs.dgsw.domain.repository.AccountRepository
import kr.hs.dgsw.domain.request.AccountRequest

class InsertAccountUseCase(private val repository: AccountRepository):
    ParamsUseCase<InsertAccountUseCase.Params, Completable>() {


    override fun buildUseCaseObservable(params: Params): Completable {
        return repository.insertAccount(params.token, params.request)
    }

    data class Params(
        val token: String,
        val request: AccountRequest
    )
}