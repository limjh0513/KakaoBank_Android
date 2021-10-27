package kr.hs.dgsw.domain.usecase.auth

import io.reactivex.Completable
import kr.hs.dgsw.domain.base.ParamsUseCase
import kr.hs.dgsw.domain.repository.AuthRepository
import kr.hs.dgsw.domain.request.EasyLoginRequest

class EasyLoginUseCase(private val authRepository: AuthRepository) :
    ParamsUseCase<EasyLoginUseCase.Params, Completable>() {

    override fun buildUseCaseObservable(params: Params): Completable {
        return authRepository.easyLogin(params.token, EasyLoginRequest(params.password))
    }

    data class Params(
        val token: String,
        val password: Int,
    )
}