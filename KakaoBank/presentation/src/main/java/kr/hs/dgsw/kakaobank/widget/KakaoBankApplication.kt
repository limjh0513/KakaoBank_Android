package kr.hs.dgsw.kakaobank.widget

import android.app.Application
import kr.hs.dgsw.kakaobank.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class KakaoBankApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@KakaoBankApplication)

            val modules =
                listOf(networkModule,
                    remoteModule,
                    repositoryModule,
                    serviceModule,
                    useCaseModule,
                    viewModelModule)
            modules(modules)
        }
    }
}