package kr.hs.dgsw.kakaobank.di

import kr.hs.dgsw.data.repository.AuthRepositoryImpl
import kr.hs.dgsw.domain.repository.AuthRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<AuthRepository> {AuthRepositoryImpl(get())}
}