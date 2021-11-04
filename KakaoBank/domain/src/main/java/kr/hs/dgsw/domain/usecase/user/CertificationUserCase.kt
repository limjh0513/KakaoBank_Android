package kr.hs.dgsw.domain.usecase.user

import io.reactivex.Single
import kr.hs.dgsw.domain.base.ParamsUseCase
import kr.hs.dgsw.domain.repository.UserRepository
import kr.hs.dgsw.domain.request.SelfCertificationRequest

class CertificationUserCase(private val userRepository: UserRepository) :
    ParamsUseCase<CertificationUserCase.Params, Single<Boolean>>() {

    override fun buildUseCaseObservable(params: Params): Single<Boolean> {
        return userRepository.certify(params.token, SelfCertificationRequest(params.name, params.rrm))
    }

    data class Params(
        val token: String,
        val name: String,
        val rrm: String
    )
}