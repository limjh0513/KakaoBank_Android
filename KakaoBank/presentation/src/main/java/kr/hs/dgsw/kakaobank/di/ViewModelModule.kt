package kr.hs.dgsw.kakaobank.di

import kr.hs.dgsw.kakaobank.viewmodel.*
import kr.hs.dgsw.kakaobank.viewmodel.openup.*
import kr.hs.dgsw.kakaobank.viewmodel.signup.*
import kr.hs.dgsw.kakaobank.viewmodel.transfer.TransferInputViewModel
import kr.hs.dgsw.kakaobank.viewmodel.transfer.TransferPasswordViewModel
import kr.hs.dgsw.kakaobank.viewmodel.transfer.TransferPriceViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    //activity
    viewModel { StartViewModel() }
    viewModel { SignupViewModel() }
    viewModel { LoginViewModel(get()) }
    viewModel { EasyLoginViewModel(get()) }
    viewModel { MainViewModel(get()) }
    viewModel { OpenupViewModel() }

    //signup Fragment
    viewModel { AskImageViewModel() }
    viewModel { PasswordReputViewModel(get()) }
    viewModel { SignupInputViewModel(get()) }
    viewModel { SignupPasswordViewModel() }
    viewModel { SignupSelectImgViewModel() }
    viewModel { SignupTermsViewModel() }

    //openup Fragment
    viewModel { BankBookNickViewModel() }
    viewModel { OpenupInputViewModel(get()) }
    viewModel { OpenupPasswordViewModel() }
    viewModel { OpenupTermsViewModel() }
    viewModel { OpenupRePasswordViewModel(get()) }

    //transfer Fragment
    viewModel { TransferInputViewModel() }
    viewModel { TransferPasswordViewModel() }
    viewModel { TransferPriceViewModel() }
}