package kr.hs.dgsw.data.network.service

import io.reactivex.Single
import kr.hs.dgsw.data.network.Response
import kr.hs.dgsw.data.network.response.AvailableData
import kr.hs.dgsw.data.network.response.LoginData
import kr.hs.dgsw.domain.request.EasyLoginRequest
import kr.hs.dgsw.domain.request.LoginRequest
import kr.hs.dgsw.domain.request.RegisterRequest
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.*

interface AuthService {
    //로그인
    @POST("auth/login")
    fun login(@Body request: LoginRequest): Single<retrofit2.Response<Response<LoginData>>>

    //간편 로그인
    @POST("user/certify")
    fun easyLogin(
        @Header("Authorization") token: String,
        @Body request: EasyLoginRequest,
    ): Single<retrofit2.Response<Response<Any>>>

    //회원가입
    @Multipart
    @POST("auth/register")
    fun register(
        @PartMap request: HashMap<String, RequestBody>,
        @Part file: MultipartBody.Part?,
    ): Single<retrofit2.Response<Response<Any>>>

    //아이디 중복확인
    @POST("auth/available/id")
    fun available(@Body id: String): Single<retrofit2.Response<Response<AvailableData>>>
}