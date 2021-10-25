package kr.hs.dgsw.data.network.service

import io.reactivex.Single
import kr.hs.dgsw.data.network.Response
import kr.hs.dgsw.data.network.response.AccountData
import retrofit2.http.GET
import retrofit2.http.Header

interface AccountService {

    //계좌 목록
    @GET("/account")
    fun getAccountList(@Header("Authorization") token: String): Single<retrofit2.Response<Response<AccountData>>>
}