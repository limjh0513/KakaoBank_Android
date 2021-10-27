package kr.hs.dgsw.domain.repository

import io.reactivex.Completable
import io.reactivex.Single
import kr.hs.dgsw.domain.request.EasyLoginRequest
import kr.hs.dgsw.domain.request.LoginRequest
import kr.hs.dgsw.domain.request.RegisterRequest
import okhttp3.MultipartBody

interface AuthRepository {
    fun login(loginRequest: LoginRequest): Single<String>
    fun easyLogin(token: String, easyLoginRequest: EasyLoginRequest): Completable
    fun register(registerRequest: RegisterRequest, file: MultipartBody.Part?): Completable
    fun available(id: String): Single<Boolean>
}