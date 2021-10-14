package kr.hs.dgsw.data.repository

import io.reactivex.Completable
import io.reactivex.Single
import kr.hs.dgsw.data.network.remote.AuthRemote
import kr.hs.dgsw.domain.repository.AuthRepository
import kr.hs.dgsw.domain.request.LoginRequest
import kr.hs.dgsw.domain.request.RegisterRequest

class AuthRepositoryImpl(private val authRemote: AuthRemote) : AuthRepository {
    override fun login(loginRequest: LoginRequest): Single<String> = authRemote.login(loginRequest)

    override fun register(registerRequest: RegisterRequest): Completable =
        authRemote.register(registerRequest).ignoreElement()

}