package kr.hs.dgsw.domain.usecase.auth

import io.reactivex.Single
import kr.hs.dgsw.domain.base.ParamsUseCase
import kr.hs.dgsw.domain.repository.AuthRepository
import kr.hs.dgsw.domain.request.LoginRequest

class LoginUseCase(private val authRepository: AuthRepository):
    ParamsUseCase<LoginUseCase.Params, Single<String>>() {

    override fun buildUseCaseObservable(params: Params): Single<String> {
        return authRepository.login(LoginRequest(params.id, params.password))
    }

    data class Params(
        val id: String,
        val password: String
    )
}