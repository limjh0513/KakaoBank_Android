package kr.hs.dgsw.data.network.service

import io.reactivex.Single
import kr.hs.dgsw.data.network.Response
import kr.hs.dgsw.domain.model.User
import kr.hs.dgsw.domain.request.EasyLoginRequest
import kr.hs.dgsw.domain.request.SelfCertificationRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface UserService {

    //간편 로그인
    @POST("user/certify")
    fun easyLogin(
        @Header("Authorization") token: String,
        @Body request: EasyLoginRequest,
    ): Single<retrofit2.Response<Response<Any>>>

    //본인 인증
    @POST("user/self/certification")
    fun certification(
        @Header("Authorization") token: String,
        @Body request: SelfCertificationRequest,
    ): Single<retrofit2.Response<Response<Boolean>>>

    @GET("user")
    fun getUser(
        @Header("Authorization") token: String
    ): Single<retrofit2.Response<Response<User>>>
}