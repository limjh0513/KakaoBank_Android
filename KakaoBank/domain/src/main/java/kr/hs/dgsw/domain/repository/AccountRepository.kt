package kr.hs.dgsw.domain.repository

import io.reactivex.Completable
import io.reactivex.Single
import kr.hs.dgsw.domain.model.Account
import kr.hs.dgsw.domain.request.AccountRequest
import kr.hs.dgsw.domain.request.OtherAccountRequest
import okhttp3.MultipartBody

interface AccountRepository {
    fun getAccount(token: String): Single<List<Account>>

    fun insertAccount(token: String, request: AccountRequest): Completable

    fun getOtherBankAccount(token: String): Single<List<Account>>

    fun postOtherBankAccount(token: String, request: OtherAccountRequest): Completable
}