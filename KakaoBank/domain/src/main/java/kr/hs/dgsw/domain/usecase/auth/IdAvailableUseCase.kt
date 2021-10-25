package kr.hs.dgsw.domain.usecase.auth

import io.reactivex.Single
import kr.hs.dgsw.domain.base.ParamsUseCase
import kr.hs.dgsw.domain.repository.AuthRepository

class IdAvailableUseCase(private val authRepository: AuthRepository): ParamsUseCase<IdAvailableUseCase.Params, Single<Boolean>>() {

    override fun buildUseCaseObservable(params: Params): Single<Boolean> {
        return authRepository.available(params.id)
    }

    data class Params(
        val id: String
    )

}