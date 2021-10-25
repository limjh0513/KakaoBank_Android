package kr.hs.dgsw.data.network.service

import io.reactivex.Single
import kr.hs.dgsw.data.network.Response
import kr.hs.dgsw.data.network.response.AvailableData
import kr.hs.dgsw.data.network.response.LoginData
import kr.hs.dgsw.domain.request.LoginRequest
import kr.hs.dgsw.domain.request.RegisterRequest
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface AuthService {
    @POST("auth/login")
    fun login(@Body request: LoginRequest): Single<retrofit2.Response<Response<LoginData>>>

    //회원가입
    @POST("auth/register")
    fun register(@Body request: RegisterRequest): Single<retrofit2.Response<Response<Any>>>

    //아이디 중복확인
    @POST("auth/available/id")
    fun available(@Body id: String): Single<retrofit2.Response<Response<AvailableData>>>
}