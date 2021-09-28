package kr.hs.dgsw.kakaobank.di

import kr.hs.dgsw.kakaobank.viewmodel.SignupViewModel
import kr.hs.dgsw.kakaobank.viewmodel.StartViewModel
import kr.hs.dgsw.kakaobank.viewmodel.signup.*
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    //activity
    viewModel { StartViewModel() }
    viewModel { SignupViewModel() }

    //signup Fragment
    viewModel { PasswordReputViewModel() }
    viewModel { SignupInputViewModel() }
    viewModel { SignupPasswordViewModel() }
    viewModel { SignupSelectImgViewModel() }
    viewModel { SignupTermsViewModel() }
}