package kr.hs.dgsw.domain.usecase.account

import io.reactivex.Completable
import kr.hs.dgsw.domain.base.ParamsUseCase
import kr.hs.dgsw.domain.repository.AccountRepository
import kr.hs.dgsw.domain.request.ImportRequest
import kr.hs.dgsw.domain.request.TransferRequest

class ImportMoneyUseCase(private val repository: AccountRepository) :
    ParamsUseCase<ImportMoneyUseCase.Params, Completable>() {

    override fun buildUseCaseObservable(params: Params): Completable {
        return repository.importMoney(params.token, params.request)
    }

    data class Params(
        val token: String,
        val request: ImportRequest,
    )
}