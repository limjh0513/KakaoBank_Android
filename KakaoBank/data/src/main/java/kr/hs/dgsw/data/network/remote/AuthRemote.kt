package kr.hs.dgsw.data.network.remote

import android.util.Log
import io.reactivex.Single
import kr.hs.dgsw.data.base.BaseRemote
import kr.hs.dgsw.data.network.response.AvailableData
import kr.hs.dgsw.data.network.response.LoginData
import kr.hs.dgsw.data.network.service.AuthService
import kr.hs.dgsw.domain.request.LoginRequest
import kr.hs.dgsw.domain.request.RegisterRequest

class AuthRemote(override val service: AuthService) : BaseRemote<AuthService>() {
    fun login(request: LoginRequest): Single<String> =
        service.login(request).map(getResponseData()).map(LoginData::token)

    fun register(request: RegisterRequest): Single<String> =
        service.register(request).map(getResponseMessage())

    fun available(id: String): Single<Boolean> =
        service.available(id).map(getResponseData()).map(AvailableData::available)
}