package kr.hs.dgsw.kakaobank.di

import io.reactivex.schedulers.Schedulers.single
import kr.hs.dgsw.data.network.remote.AccountRemote
import kr.hs.dgsw.data.network.remote.AuthRemote
import kr.hs.dgsw.data.network.remote.UserRemote
import org.koin.dsl.module

val remoteModule = module {
    single { AuthRemote(get()) }
    single { AccountRemote(get()) }
    single { UserRemote(get()) }
}