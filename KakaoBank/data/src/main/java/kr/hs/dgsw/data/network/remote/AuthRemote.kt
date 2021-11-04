package kr.hs.dgsw.data.network.remote

import android.util.Log
import io.reactivex.Single
import kr.hs.dgsw.data.base.BaseRemote
import kr.hs.dgsw.data.network.response.AvailableData
import kr.hs.dgsw.data.network.response.LoginData
import kr.hs.dgsw.data.network.service.AuthService
import kr.hs.dgsw.domain.request.EasyLoginRequest
import kr.hs.dgsw.domain.request.LoginRequest
import kr.hs.dgsw.domain.request.RegisterRequest
import okhttp3.MultipartBody
import okhttp3.RequestBody

class AuthRemote(override val service: AuthService) : BaseRemote<AuthService>() {
    fun login(request: LoginRequest): Single<String> =
        service.login(request).map(getResponseData()).map(LoginData::token)

    fun register(request: HashMap<String, RequestBody>, file: MultipartBody.Part?): Single<String> =
        service.register(request , file).map(getResponseMessage())

    fun available(id: String): Single<Boolean> =
        service.available(id).map(getResponseData()).map(AvailableData::available)
}