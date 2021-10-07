package kr.hs.dgsw.kakaobank.di

import kr.hs.dgsw.kakaobank.viewmodel.*
import kr.hs.dgsw.kakaobank.viewmodel.openup.BankBookNickViewModel
import kr.hs.dgsw.kakaobank.viewmodel.openup.OpenupInputViewModel
import kr.hs.dgsw.kakaobank.viewmodel.openup.OpenupPasswordViewModel
import kr.hs.dgsw.kakaobank.viewmodel.openup.OpenupTermsViewModel
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
    viewModel { SignupInputViewModel() }
    viewModel { SignupPasswordViewModel() }
    viewModel { SignupSelectImgViewModel() }
    viewModel { SignupTermsViewModel() }

    //openup Fragment
    viewModel { BankBookNickViewModel() }
    viewModel { OpenupInputViewModel() }
    viewModel { OpenupPasswordViewModel() }
    viewModel {OpenupTermsViewModel()}
}