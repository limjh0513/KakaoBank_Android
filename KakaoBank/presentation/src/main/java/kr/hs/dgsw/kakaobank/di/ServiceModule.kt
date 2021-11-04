package kr.hs.dgsw.kakaobank.di

import kr.hs.dgsw.data.network.service.AccountService
import kr.hs.dgsw.data.network.service.AuthService
import kr.hs.dgsw.data.network.service.UserService
import org.koin.dsl.module
import retrofit2.Retrofit

val serviceModule = module {
    single { (get() as Retrofit).create(AuthService::class.java) }
    single { (get() as Retrofit).create(AccountService::class.java) }
    single { (get() as Retrofit).create(UserService::class.java) }
}