package kr.hs.dgsw.kakaobank.view.fragment.transfer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val bankNumber = arguments?.getInt("bankNumber")

        if (bankNumber != null) {
            when (bankNumber) {
                1 -> {
                    mBinding.transferIBankImage.setImageResource(R.drawable.toss)
                    mBinding.transferITvBankChoice.text = "토스"
                    (activity as TransferActivity).request.toBank = "TOSS"
                    (activity as TransferActivity).bank = "토스"
                }
                2 -> {
                    mBinding.transferIBankImage.setImageResource(R.drawable.kakao)
                    mBinding.transferITvBankChoice.text = "카카오뱅크"
                    (activity as TransferActivity).request.toBank = "KAKAO"
                    (activity as TransferActivity).bank = "카카오뱅크"
                }
                3 -> {
                    mBinding.transferIBankImage.setImageResource(R.drawable.kbank)
                    mBinding.transferITvBankChoice.text = "K뱅크"
                    (activity as TransferActivity).request.toBank = "KBANK"
                    (activity as TransferActivity).bank = "K뱅크"
                }
                4 -> {
                    mBinding.transferIBankImage.setImageResource(R.drawable.deagu)
                    mBinding.transferITvBankChoice.text = "대구은행"
                    (activity as TransferActivity).request.toBank = "DEAGU"
                    (activity as TransferActivity).bank = "대구은행"
                }
                5 -> {
                    mBinding.transferIBankImage.setImageResource(R.drawable.maggu)
                    mBinding.transferITvBankChoice.text = "머구은행"
                    (activity as TransferActivity).request.toBank = "MAGGU"
                    (activity as TransferActivity).bank = "머구은행"
                }
            }
        }

        return super.onCreateView(inflater, container, savedInstanceState)
    }

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
                if (it.isNotEmpty()) {
                    mBinding.transferINumber.text = it
                } else {
                    mBinding.transferINumber.text = ""
                }

                if (it.length > 11) {
                    mBinding.transferIConfirmBtn.setBackgroundColor(ContextCompat.getColor(
                        requireContext(),
                        R.color.kakao))
                    mBinding.transferIConfirmBtn.setTextColor(ContextCompat.getColor(requireContext(),
                        R.color.text_mainColor))
                    mBinding.transferIConfirmBtn.setOnClickListener {
                        (activity as TransferActivity).request.toAccountNumber = "$it"
                        this@TransferInputFragment.findNavController()
                            .navigate(R.id.action_transferInputFragment_to_transferConfirmFragment)
                    }
                }
            })

            bankSelectBtn.observe(this@TransferInputFragment, Observer {
                val dialog = TransferBankFragment()
                dialog.show(requireActivity().supportFragmentManager, dialog.tag)
            })


        }
    }
}