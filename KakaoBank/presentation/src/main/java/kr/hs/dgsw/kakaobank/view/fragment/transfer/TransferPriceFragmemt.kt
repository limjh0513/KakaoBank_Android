package kr.hs.dgsw.kakaobank.view.fragment.transfer

import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import kr.hs.dgsw.kakaobank.R
import kr.hs.dgsw.kakaobank.base.BaseFragment
import kr.hs.dgsw.kakaobank.databinding.FragmentTransferPriceBinding
import kr.hs.dgsw.kakaobank.view.activity.TransferActivity
import kr.hs.dgsw.kakaobank.viewmodel.transfer.TransferPriceViewModel
import kr.hs.dgsw.kakaobank.widget.getRestNumber
import org.koin.android.ext.android.inject

class TransferPriceFragmemt : BaseFragment<FragmentTransferPriceBinding, TransferPriceViewModel>() {
    override val mViewModel: TransferPriceViewModel by inject()
    override val layoutRes: Int
        get() = R.layout.fragment_transfer_price

    override fun observerViewModel() {
        setTransferInformation()

        with(mViewModel) {
            cancelBtn.observe(this@TransferPriceFragmemt, Observer {
                requireActivity().finish()
            })

            backBtn.observe(this@TransferPriceFragmemt, Observer {
                if (transferMoney.value?.length!! > 0) {
                    val str = transferMoney.value!!.substring(0, transferMoney.value!!.length - 1)
                    transferMoney.value = str
                }
            })

            transferMoney.observe(this@TransferPriceFragmemt, Observer {
                if (it.isNotEmpty()) {
                    mBinding.transferPPrice.text = getRestNumber(it)
                    (activity as TransferActivity).request.toMoney = Integer.parseInt(it)
                } else {
                    mBinding.transferPPrice.text = ""
                }

                if (it.isNotEmpty()) {
                    mBinding.transferPConfirmBtn.setBackgroundColor(ContextCompat.getColor(
                        requireContext(),
                        R.color.kakao))
                    mBinding.transferPConfirmBtn.setTextColor(ContextCompat.getColor(requireContext(),
                        R.color.text_mainColor))
                    mBinding.transferPConfirmBtn.setOnClickListener {
                        (activity as TransferActivity).request.toAccountNumber = "$it"
                        this@TransferPriceFragmemt.findNavController()
                            .navigate(R.id.action_transferPriceFragmemt_to_transferPasswordFragment)
                    }
                }
            })
        }
    }

    private fun setTransferInformation() {
        val infor = (activity as TransferActivity).request
        val money = (activity as TransferActivity).money
        val bank = (activity as TransferActivity).bank
        val name = (activity as TransferActivity).accountName

        mBinding.transferPMyPrice.text = "${name} : ${money}원"
        mBinding.transferPSendNumber.text = "${bank} ${infor.toAccountNumber}"

        if (infor.toBank.equals("KAKAO")) {
            mBinding.transferPFees.text = "수수료 : 0원"
            (activity as TransferActivity).fees = 0
        } else {
            mBinding.transferPFees.text = "수수료 : 500원"
            (activity as TransferActivity).fees = 500
        }

    }
}