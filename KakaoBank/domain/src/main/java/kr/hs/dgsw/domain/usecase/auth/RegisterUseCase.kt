package kr.hs.dgsw.domain.usecase.auth

import io.reactivex.Completable
import kr.hs.dgsw.domain.base.ParamsUseCase
import kr.hs.dgsw.domain.repository.AuthRepository
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody


class RegisterUseCase(private val authRepository: AuthRepository) :
    ParamsUseCase<RegisterUseCase.Params, Completable>() {

    override fun buildUseCaseObservable(params: Params): Completable {
        var map = HashMap<String, RequestBody>()
        val id: RequestBody = RequestBody.create("text/plain".toMediaTypeOrNull(), params.id)
        val name: RequestBody = RequestBody.create("text/plain".toMediaTypeOrNull(), params.name)
        val nickName: RequestBody =
            RequestBody.create("text/plain".toMediaTypeOrNull(), params.nickName)
        val password: RequestBody =
            RequestBody.create("text/plain".toMediaTypeOrNull(), params.password);
        val phoneNumber: RequestBody =
            RequestBody.create("text/plain".toMediaTypeOrNull(), params.phoneNumber)
        val residentRegistrationNumber: RequestBody =
            RequestBody.create("text/plain".toMediaTypeOrNull(), params.residentRegistrationNumber)
        val simpleNumber: RequestBody =
            RequestBody.create("text/plain".toMediaTypeOrNull(),
                java.lang.String.valueOf(params.simpleNumber))

        map["id"] = id
        map["name"] = name
        map["nickname"] = nickName
        map["password"] = password
        map["phoneNumber"] = phoneNumber
        map["residentRegistrationNumber"] = residentRegistrationNumber
        map["simpleNumber"] = simpleNumber

        return authRepository.register(
            map, params.file)
    }

    data class Params(
        val id: String,
        val name: String,
        val nickName: String,
        val password: String,
        val phoneNumber: String,
        val residentRegistrationNumber: String,
        val simpleNumber: Int,
        val file: MultipartBody.Part?,
    )
}