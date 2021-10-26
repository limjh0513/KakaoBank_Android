package kr.hs.dgsw.data.repository

import io.reactivex.Completable
import io.reactivex.Single
import kr.hs.dgsw.data.network.remote.AccountRemote
import kr.hs.dgsw.domain.model.Account
import kr.hs.dgsw.domain.repository.AccountRepository
import kr.hs.dgsw.domain.request.AccountRequest
import okhttp3.MultipartBody

class AccountRepositoryImpl(private val remote: AccountRemote): AccountRepository {
    override fun getAccount(token: String): Single<List<Account>> =
        remote.getAccountList(token)

    override fun insertAccount(token: String, request: AccountRequest): Completable =
        remote.insertAccount(token, request).ignoreElement()
}