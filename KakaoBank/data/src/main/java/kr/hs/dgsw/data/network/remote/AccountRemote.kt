package kr.hs.dgsw.data.network.remote

import io.reactivex.Single
import kr.hs.dgsw.data.base.BaseRemote
import kr.hs.dgsw.data.network.service.AccountService
import kr.hs.dgsw.domain.model.Account
import kr.hs.dgsw.domain.request.AccountRequest
import okhttp3.MultipartBody

class AccountRemote(override val service: AccountService): BaseRemote<AccountService>() {
    fun getAccountList(token: String): Single<List<Account>> =
        service.getAccountList(token).map(getResponseData())

    fun insertAccount(token: String, request: AccountRequest): Single<String> =
        service.insertAccount(token, request).map(getResponseMessage())
}