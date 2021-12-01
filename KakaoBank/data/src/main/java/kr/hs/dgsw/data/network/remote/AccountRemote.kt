package kr.hs.dgsw.data.network.remote

import io.reactivex.Single
import kr.hs.dgsw.data.base.BaseRemote
import kr.hs.dgsw.data.network.service.AccountService
import kr.hs.dgsw.domain.model.Account
import kr.hs.dgsw.domain.request.AccountRequest
import kr.hs.dgsw.domain.request.ImportRequest
import kr.hs.dgsw.domain.request.OtherAccountRequest
import kr.hs.dgsw.domain.request.TransferRequest

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

    //다른 은행 계좌 추가하기
    fun postOtherBankAccount(token: String, request: OtherAccountRequest): Single<String> =
        service.postOtherBankAccount(token, request).map(getResponseMessage())

    //이체하기
    fun transferMoney(token: String, request: TransferRequest): Single<String> =
        service.transferMoney(token, request).map(getResponseMessage())

    //가져오기
    fun importMoney(token: String, request: ImportRequest): Single<String> =
        service.importMoney(token, request).map(getResponseMessage())

    //비밀번호 확인
    fun checkPassword(token: String, accountNumber: String, password: String): Single<Boolean> =
        service.checkPassword(token, accountNumber, password).map(getResponseData())
}