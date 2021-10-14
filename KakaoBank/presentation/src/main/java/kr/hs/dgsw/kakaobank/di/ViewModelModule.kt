package kr.hs.dgsw.kakaobank.di

import kr.hs.dgsw.kakaobank.viewmodel.*
import kr.hs.dgsw.kakaobank.viewmodel.openup.*
import kr.hs.dgsw.kakaobank.viewmodel.signup.*
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    //activity
    viewModel { StartViewModel() }
    viewModel { SignupViewModel() }
    viewModel { LoginViewModel() }
    viewModel { EasyLoginViewModel() }
    viewModel { MainViewModel() }
    viewModel { OpenupViewModel() }

    //signup Fragment
    viewModel { AskImageViewModel() }
    viewModel { PasswordReputViewModel() }
    viewModel { SignupInputViewModel(get()) }
    viewModel { SignupPasswordViewModel() }
    viewModel { SignupSelectImgViewModel() }
    viewModel { SignupTermsViewModel() }

    //openup Fragment
    viewModel { BankBookNickViewModel() }
    viewModel { OpenupInputViewModel() }
    viewModel { OpenupPasswordViewModel() }
    viewModel { OpenupTermsViewModel() }
    viewModel { OpenupRePasswordViewModel() }
}