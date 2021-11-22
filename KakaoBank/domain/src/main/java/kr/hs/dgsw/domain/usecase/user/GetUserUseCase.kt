package kr.hs.dgsw.domain.usecase.user

import io.reactivex.Completable
import io.reactivex.Single
import kr.hs.dgsw.domain.base.ParamsUseCase
import kr.hs.dgsw.domain.model.User
import kr.hs.dgsw.domain.repository.UserRepository
import kr.hs.dgsw.domain.request.EasyLoginRequest

class GetUserUseCase(private val userRepository: UserRepository) :
    ParamsUseCase<GetUserUseCase.Params, Single<User>>() {

    override fun buildUseCaseObservable(params: Params): Single<User> {
        return userRepository.getUser(params.token)
    }

    data class Params(
        val token: String,
    )

}