package kr.hs.dgsw.domain.usecase.account

import io.reactivex.Single
import kr.hs.dgsw.domain.base.ParamsUseCase
import kr.hs.dgsw.domain.model.Account
import kr.hs.dgsw.domain.repository.AccountRepository

class GetAccountUseCase(private val repository: AccountRepository):
    ParamsUseCase<GetAccountUseCase.Params, Single<List<Account>>>() {

    override fun buildUseCaseObservable(params: Params): Single<List<Account>> {
        return repository.getAccount(params.token)
    }

    data class Params(
        val token: String
    )
}