package kr.hs.dgsw.kakaobank.di

import kr.hs.dgsw.kakaobank.viewmodel.*
import kr.hs.dgsw.kakaobank.viewmodel.impor.ImportMoneyViewModel
import kr.hs.dgsw.kakaobank.viewmodel.impor.ImportPasswordViewModel
import kr.hs.dgsw.kakaobank.viewmodel.impor.ImportSelectViewModel
import kr.hs.dgsw.kakaobank.viewmodel.openup.*
import kr.hs.dgsw.kakaobank.viewmodel.other.OtherSelectViewModel
import kr.hs.dgsw.kakaobank.viewmodel.other.OtherTermsViewModel
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
    viewModel { MainViewModel(get(), get()) }
    viewModel { OpenupViewModel() }
    viewModel { ImportViewModel() }
    viewModel { OtherViewModel() }
    viewModel { TransferViewModel() }
    viewModel { SettingViewModel() }

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
    viewModel { TransferPasswordViewModel(get(), get()) }
    viewModel { TransferPriceViewModel() }

    //Import Fragment
    viewModel { ImportSelectViewModel(get()) }
    viewModel { ImportMoneyViewModel() }
    viewModel { ImportPasswordViewModel(get(), get()) }

    //Other Fragment
    viewModel { OtherTermsViewModel() }
    viewModel { OtherSelectViewModel(get(), get()) }

}