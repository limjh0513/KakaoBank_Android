package kr.hs.dgsw.kakaobank.view.fragment.transfer

import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import kr.hs.dgsw.kakaobank.R
import kr.hs.dgsw.kakaobank.base.BaseFragment
import kr.hs.dgsw.kakaobank.databinding.FragmentTransferBankBinding
import kr.hs.dgsw.kakaobank.view.activity.TransferActivity
import kr.hs.dgsw.kakaobank.viewmodel.transfer.TransferBankViewModel
import org.koin.android.ext.android.inject

class TransferBankFragment : BaseFragment<FragmentTransferBankBinding, TransferBankViewModel>() {
    override val mViewModel: TransferBankViewModel by inject()
    override val layoutRes: Int
        get() = R.layout.fragment_transfer_bank

    override fun observerViewModel() {
        with(mViewModel) {
            backBtn.observe(this@TransferBankFragment, Observer {
                requireActivity().finish()
            })

            kakaoBankBtn.observe(this@TransferBankFragment, Observer {
                (activity as TransferActivity).request.toBank = "KAKAO"
                (activity as TransferActivity).bank = "카카오"
                this@TransferBankFragment.findNavController()
                    .navigate(R.id.action_transferBankFragment_to_transferPriceFragmemt)

            })

            tossBankBtn.observe(this@TransferBankFragment, Observer {
                (activity as TransferActivity).request.toBank = "TOSS"
                (activity as TransferActivity).bank = "토스"
                this@TransferBankFragment.findNavController()
                    .navigate(R.id.action_transferBankFragment_to_transferPriceFragmemt)
            })

            deaguBankBtn.observe(this@TransferBankFragment, Observer {
                (activity as TransferActivity).request.toBank = "DEAGU"
                (activity as TransferActivity).bank = "대구은행"
                this@TransferBankFragment.findNavController()
                    .navigate(R.id.action_transferBankFragment_to_transferPriceFragmemt)
            })

            kBankBtn.observe(this@TransferBankFragment, Observer {
                (activity as TransferActivity).request.toBank = "KBANK"
                (activity as TransferActivity).bank = "케이뱅크"
                this@TransferBankFragment.findNavController()
                    .navigate(R.id.action_transferBankFragment_to_transferPriceFragmemt)
            })

            magguBtn.observe(this@TransferBankFragment, Observer {
                (activity as TransferActivity).request.toBank = "MAGGU"
                (activity as TransferActivity).bank = "머구은행"
                this@TransferBankFragment.findNavController()
                    .navigate(R.id.action_transferBankFragment_to_transferPriceFragmemt)
            })
        }
    }


}