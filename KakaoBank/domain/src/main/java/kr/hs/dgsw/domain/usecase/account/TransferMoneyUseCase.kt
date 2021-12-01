package kr.hs.dgsw.domain.usecase.account

import io.reactivex.Completable
import kr.hs.dgsw.domain.base.ParamsUseCase
import kr.hs.dgsw.domain.repository.AccountRepository
import kr.hs.dgsw.domain.request.OtherAccountRequest
import kr.hs.dgsw.domain.request.TransferRequest

class TransferMoneyUseCase(private val repository: AccountRepository) :
    ParamsUseCase<TransferMoneyUseCase.Params, Completable>() {

    override fun buildUseCaseObservable(params: Params): Completable {
        return repository.transferMoney(params.token, params.request)
    }

    data class Params(
        val token: String,
        val request: TransferRequest,
    )
}