package kr.hs.dgsw.kakaobank.di

import kr.hs.dgsw.domain.usecase.auth.LoginUseCase
import kr.hs.dgsw.domain.usecase.auth.RegisterUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { LoginUseCase(get()) }
    single { RegisterUseCase(get()) }
}