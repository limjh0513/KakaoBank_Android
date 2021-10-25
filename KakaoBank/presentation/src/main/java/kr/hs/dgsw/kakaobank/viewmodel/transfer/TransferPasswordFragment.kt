package kr.hs.dgsw.kakaobank.viewmodel.transfer

import kr.hs.dgsw.kakaobank.R
import kr.hs.dgsw.kakaobank.base.BaseFragment
import kr.hs.dgsw.kakaobank.databinding.FragmentTransferPasswordBinding
import org.koin.android.ext.android.inject


class TransferPasswordFragment : BaseFragment<FragmentTransferPasswordBinding, TransferPasswordViewModel>() {
    override val mViewModel: TransferPasswordViewModel by inject()
    override val layoutRes: Int
        get() = R.layout.fragment_transfer_password

    override fun observerViewModel() {
        with(mViewModel){

        }
    }

}