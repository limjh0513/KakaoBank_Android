package kr.hs.dgsw.data.network.service

import io.reactivex.Single
import kr.hs.dgsw.data.network.Response
import kr.hs.dgsw.domain.model.Account
import kr.hs.dgsw.domain.request.AccountRequest
import kr.hs.dgsw.domain.request.ImportRequest
import kr.hs.dgsw.domain.request.OtherAccountRequest
import kr.hs.dgsw.domain.request.TransferRequest
import retrofit2.http.*

interface AccountService {

    //계좌 목록
    @GET("account")
    fun getAccountList(@Header("Authorization") token: String): Single<retrofit2.Response<Response<List<Account>>>>

    //계좌 생성
    @POST("account")
    fun insertAccount(
        @Header("Authorization") token: String,
        @Body accountDto: AccountRequest,
    ): Single<retrofit2.Response<Response<Any>>>

    //타 은행에서 내 계좌 보기
    @GET("account/other")
    fun getOtherBankAccount(@Header("Authorization") token: String): Single<retrofit2.Response<Response<List<Account>>>>

    //타 은행 계좌 추가하기
    @POST("account/other")
    fun postOtherBankAccount(
        @Header("Authorization") token: String,
        @Body storeAccountDto: OtherAccountRequest,
    ): Single<retrofit2.Response<Response<Any>>>

    //이체하기
    @POST("account/remittance")
    fun transferMoney(
        @Header("Authorization") token: String,
        @Body remittanceDto: TransferRequest,
    ): Single<retrofit2.Response<Response<Any>>>

    //카카오뱅크 계좌에서 가져오기
    @POST("/account/take")
    fun importMoney(
        @Header("Authorization") token: String,
        @Body
        takeMoneyDto: ImportRequest,
    ): Single<retrofit2.Response<Response<Any>>>

    //비밀번호 확인
    @GET("/account/check/{accountNumber}")
    fun checkPassword(
        @Header("Authorization") token: String,
        @Path("accountNumber") accountNumber: String,
        @Query("password") password: String,
    ): Single<retrofit2.Response<Response<Boolean>>>
}