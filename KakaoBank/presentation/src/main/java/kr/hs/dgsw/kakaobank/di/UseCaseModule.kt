package kr.hs.dgsw.kakaobank.di

import kr.hs.dgsw.domain.usecase.account.GetAccountUseCase
import kr.hs.dgsw.domain.usecase.account.InsertAccountUseCase
import kr.hs.dgsw.domain.usecase.auth.IdAvailableUseCase
import kr.hs.dgsw.domain.usecase.auth.LoginUseCase
import kr.hs.dgsw.domain.usecase.auth.RegisterUseCase
import org.koin.dsl.module

val useCaseModule = module {
    //Auth
    single { LoginUseCase(get()) }
    single { RegisterUseCase(get()) }
    single { IdAvailableUseCase(get()) }

    //Account
    single { GetAccountUseCase(get()) }
    single { InsertAccountUseCase(get()) }
}