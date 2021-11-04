package kr.hs.dgsw.data.repository

import io.reactivex.Completable
import io.reactivex.Single
import kr.hs.dgsw.data.network.remote.UserRemote
import kr.hs.dgsw.domain.repository.UserRepository
import kr.hs.dgsw.domain.request.EasyLoginRequest
import kr.hs.dgsw.domain.request.SelfCertificationRequest

class UserRepositoryImpl(private val userRemote: UserRemote) : UserRepository {
    override fun easyLogin(token: String, easyLoginRequest: EasyLoginRequest): Completable =
        userRemote.easyLogin(token, easyLoginRequest).ignoreElement()

    override fun certify(
        token: String,
        selfCertificationRequest: SelfCertificationRequest,
    ): Single<Boolean> = userRemote.selfCertify(token, selfCertificationRequest)
}