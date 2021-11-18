package kr.hs.dgsw.data.network.remote

import io.reactivex.Single
import kr.hs.dgsw.data.base.BaseRemote
import kr.hs.dgsw.data.network.service.AccountService
import kr.hs.dgsw.domain.model.Account
import kr.hs.dgsw.domain.request.AccountRequest
import okhttp3.MultipartBody

class AccountRemote(override val service: AccountService) : BaseRemote<AccountService>() {
    //계좌 목록 받아오기
    fun getAccountList(token: String): Single<List<Account>> =
        service.getAccountList(token).map(getResponseData())

    //계좌 등록
    fun insertAccount(token: String, request: AccountRequest): Single<String> =
        service.insertAccount(token, request).map(getResponseMessage())

    //다른 은행에서 내 계좌 보기
    fun getOtherBankAccount(token: String): Single<List<Account>> =
        service.getOtherBankAccount(token).map(getResponseData())
}