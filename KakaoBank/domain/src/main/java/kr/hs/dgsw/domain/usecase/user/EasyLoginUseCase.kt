package kr.hs.dgsw.domain.usecase.user

import io.reactivex.Completable
import kr.hs.dgsw.domain.base.ParamsUseCase
import kr.hs.dgsw.domain.repository.AuthRepository
import kr.hs.dgsw.domain.repository.UserRepository
import kr.hs.dgsw.domain.request.EasyLoginRequest

class EasyLoginUseCase(private val userRepository: UserRepository) :
    ParamsUseCase<EasyLoginUseCase.Params, Completable>() {

    override fun buildUseCaseObservable(params: Params): Completable {
        return userRepository.easyLogin(params.token, EasyLoginRequest(params.password))
    }

    data class Params(
        val token: String,
        val password: Int,
    )
}