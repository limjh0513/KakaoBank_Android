package kr.hs.dgsw.data.network.remote

import io.reactivex.Single
import kr.hs.dgsw.data.base.BaseRemote
import kr.hs.dgsw.data.network.service.UserService
import kr.hs.dgsw.domain.request.EasyLoginRequest
import kr.hs.dgsw.domain.request.SelfCertificationRequest

class UserRemote(override val service: UserService) : BaseRemote<UserService>() {
    //간편로그인
    fun easyLogin(token: String, request: EasyLoginRequest): Single<String> =
        service.easyLogin(token, request).map(getResponseMessage())

    //본인인증
    fun selfCertify(token: String, request: SelfCertificationRequest): Single<Boolean> =
        service.certification(token, request).map(getResponseData())
}