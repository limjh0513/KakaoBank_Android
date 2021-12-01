package kr.hs.dgsw.domain.repository

import io.reactivex.Completable
import io.reactivex.Single
import kr.hs.dgsw.domain.model.Account
import kr.hs.dgsw.domain.request.AccountRequest
import kr.hs.dgsw.domain.request.ImportRequest
import kr.hs.dgsw.domain.request.OtherAccountRequest
import kr.hs.dgsw.domain.request.TransferRequest

interface AccountRepository {
    fun getAccount(token: String): Single<List<Account>>

    fun insertAccount(token: String, request: AccountRequest): Completable

    fun getOtherBankAccount(token: String): Single<List<Account>>

    fun postOtherBankAccount(token: String, request: OtherAccountRequest): Completable

    fun transferMoney(token: String, request: TransferRequest): Completable

    fun importMoney(token: String, request: ImportRequest): Completable

    fun checkPassword(token: String, accountNumber: String, password: String): Single<Boolean>
}