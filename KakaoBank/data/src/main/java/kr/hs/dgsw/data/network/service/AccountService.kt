package kr.hs.dgsw.data.network.service

import io.reactivex.Single
import kr.hs.dgsw.data.network.Response
import kr.hs.dgsw.domain.model.Account
import kr.hs.dgsw.domain.request.AccountRequest
import okhttp3.MultipartBody
import retrofit2.http.*

interface AccountService {

    //계좌 목록
    @GET("/account")
    fun getAccountList(@Header("Authorization") token: String): Single<retrofit2.Response<Response<List<Account>>>>

    //계좌 생성
    @POST("/account")
    fun insertAccount(@Header("Authorization") token: String, @Body accountDto: AccountRequest): Single<retrofit2.Response<Response<Any>>>

    //타 은행에서 내 계좌 보기
    @GET("/account/other")
    fun getOtherBankAccount(@Header("Authorization") token: String): Single<retrofit2.Response<Response<List<Account>>>>
}