package kr.hs.dgsw.kakaobank.view.fragment.transfer

import kr.hs.dgsw.kakaobank.R
import kr.hs.dgsw.kakaobank.base.BaseFragment
import kr.hs.dgsw.kakaobank.databinding.FragmentTransferPriceBinding
import kr.hs.dgsw.kakaobank.viewmodel.transfer.TransferPriceViewModel
import org.koin.android.ext.android.inject

class TransferPriceFragmemt : BaseFragment<FragmentTransferPriceBinding, TransferPriceViewModel>() {
    override val mViewModel: TransferPriceViewModel by inject()
    override val layoutRes: Int
        get() = R.layout.fragment_transfer_price

    override fun observerViewModel() {
        with(mViewModel){

        }
    }

}