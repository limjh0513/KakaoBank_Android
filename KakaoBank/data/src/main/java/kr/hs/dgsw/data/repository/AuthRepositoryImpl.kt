package kr.hs.dgsw.data.repository

import io.reactivex.Completable
import io.reactivex.Single
import kr.hs.dgsw.data.network.remote.AuthRemote
import kr.hs.dgsw.domain.repository.AuthRepository
import kr.hs.dgsw.domain.request.EasyLoginRequest
import kr.hs.dgsw.domain.request.LoginRequest
import kr.hs.dgsw.domain.request.RegisterRequest
import okhttp3.MultipartBody
import okhttp3.RequestBody

class AuthRepositoryImpl(private val authRemote: AuthRemote) : AuthRepository {
    override fun login(loginRequest: LoginRequest): Single<String> = authRemote.login(loginRequest)

    override fun register(
        request: HashMap<String, RequestBody>,
        file: MultipartBody.Part?,
    ): Completable =
        authRemote.register(request, file).ignoreElement()

    override fun available(id: String): Single<Boolean> =
        authRemote.available(id)
}