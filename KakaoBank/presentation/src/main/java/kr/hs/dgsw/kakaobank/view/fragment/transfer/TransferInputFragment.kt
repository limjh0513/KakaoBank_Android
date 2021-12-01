package kr.hs.dgsw.kakaobank.view.fragment.transfer

import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import kr.hs.dgsw.kakaobank.R
import kr.hs.dgsw.kakaobank.base.BaseFragment
import kr.hs.dgsw.kakaobank.databinding.FragmentTransferInputBinding
import kr.hs.dgsw.kakaobank.view.activity.TransferActivity
import kr.hs.dgsw.kakaobank.viewmodel.transfer.TransferInputViewModel
import org.koin.android.ext.android.inject


class TransferInputFragment : BaseFragment<FragmentTransferInputBinding, TransferInputViewModel>() {
    override val mViewModel: TransferInputViewModel by inject()
    override val layoutRes: Int
        get() = R.layout.fragment_transfer_input


    override fun observerViewModel() {
        with(mViewModel) {
            cancelBtn.observe(this@TransferInputFragment, Observer {
                requireActivity().finish()
            })

            backBtn.observe(this@TransferInputFragment, Observer {
                if (bankBookNumber.value?.length!! > 0) {
                    val str = bankBookNumber.value!!.substring(0, bankBookNumber.value!!.length - 1)
                    bankBookNumber.value = str
                }
            })

            bankBookNumber.observe(this@TransferInputFragment, Observer {
                mBinding.transferINumber.text = "$it"
                if (it.length >= 11) {
                    mBinding.transferIConfirmBtn.setBackgroundColor(ContextCompat.getColor(
                        requireContext(),
                        R.color.kakao))
                    mBinding.transferIConfirmBtn.setTextColor(ContextCompat.getColor(
                        requireContext(),
                        R.color.text_mainColor))
                    mBinding.transferIConfirmBtn.setOnClickListener {
                        (activity as TransferActivity).request.toAccountNumber =
                            "${bankBookNumber.value}"
                        this@TransferInputFragment.findNavController()
                            .navigate(R.id.action_transferInputFragment_to_transferBankFragment)
                    }
                } else {
                    mBinding.transferIConfirmBtn.setBackgroundColor(ContextCompat.getColor(
                        requireContext(),
                        R.color.disabled))
                    mBinding.transferIConfirmBtn.setTextColor(ContextCompat.getColor(
                        requireContext(),
                        R.color.disabled_text))
                    mBinding.transferIConfirmBtn.setOnClickListener {
                    }

                }
            })

        }
    }
}