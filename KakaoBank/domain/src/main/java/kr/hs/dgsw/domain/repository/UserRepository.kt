package kr.hs.dgsw.domain.repository

import io.reactivex.Completable
import io.reactivex.Single
import kr.hs.dgsw.domain.request.EasyLoginRequest
import kr.hs.dgsw.domain.request.SelfCertificationRequest

interface UserRepository {
    fun easyLogin(token: String, easyLoginRequest: EasyLoginRequest): Completable
    fun certify(token: String, selfCertificationRequest: SelfCertificationRequest): Single<Boolean>
}