package kr.hs.dgsw.domain.repository

import io.reactivex.Completable
import io.reactivex.Single
import kr.hs.dgsw.domain.request.LoginRequest
import kr.hs.dgsw.domain.request.RegisterRequest

interface AuthRepository {
    fun login(loginRequest: LoginRequest): Single<String>
    fun register(registerRequest: RegisterRequest): Completable
    fun available(id: String): Single<Boolean>
}