package kr.hs.dgsw.data.network.remote

import io.reactivex.Single
import kr.hs.dgsw.data.base.BaseRemote
import kr.hs.dgsw.data.network.service.UserService
import kr.hs.dgsw.domain.request.EasyLoginRequest
import kr.hs.dgsw.domain.request.SelfCertificationRequest

class UserRemote(override val service: UserService) : BaseRemote<UserService>() {
    fun easyLogin(token: String, request: EasyLoginRequest): Single<String> =
        service.easyLogin(token, request).map(getResponseMessage())

    fun selfCertify(token: String, request: SelfCertificationRequest): Single<Boolean> =
        service.certification(token, request).map(getResponseData())
}