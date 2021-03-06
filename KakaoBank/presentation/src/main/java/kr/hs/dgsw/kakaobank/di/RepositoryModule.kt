package kr.hs.dgsw.kakaobank.di

import kr.hs.dgsw.data.repository.AccountRepositoryImpl
import kr.hs.dgsw.data.repository.AuthRepositoryImpl
import kr.hs.dgsw.data.repository.UserRepositoryImpl
import kr.hs.dgsw.domain.repository.AccountRepository
import kr.hs.dgsw.domain.repository.AuthRepository
import kr.hs.dgsw.domain.repository.UserRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<AuthRepository> { AuthRepositoryImpl(get()) }
    single<AccountRepository> { AccountRepositoryImpl(get()) }
    single<UserRepository> { UserRepositoryImpl(get()) }
}