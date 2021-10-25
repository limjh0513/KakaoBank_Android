package kr.hs.dgsw.domain.usecase.auth

import io.reactivex.Completable
import io.reactivex.Single
import kr.hs.dgsw.domain.base.ParamsUseCase
import kr.hs.dgsw.domain.repository.AuthRepository
import kr.hs.dgsw.domain.request.RegisterRequest
import java.io.File

class RegisterUseCase(private val authRepository: AuthRepository) :
    ParamsUseCase<RegisterUseCase.Params, Completable>() {

    override fun buildUseCaseObservable(params: Params): Completable {
        return authRepository.register(RegisterRequest(
            params.file,
            params.id,
            params.name,
            params.nickName,
            params.password,
            params.phoneNumber,
            params.residentRegistrationNumber,
        params.simpleNumber))
    }

    data class Params(
        val file: File,
        val id: String,
        val name: String,
        val nickName: String,
        val password: String,
        val phoneNumber: String,
        val residentRegistrationNumber: String,
        val simpleNumber: Int
    )
}