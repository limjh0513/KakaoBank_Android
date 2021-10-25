package kr.hs.dgsw.kakaobank.view.fragment.transfer

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import kr.hs.dgsw.kakaobank.R
import kr.hs.dgsw.kakaobank.base.BaseFragment
import kr.hs.dgsw.kakaobank.databinding.FragmentTransferInputBinding
import kr.hs.dgsw.kakaobank.viewmodel.transfer.TransferInputViewModel
import org.koin.android.ext.android.inject


class TransferInputFragment : BaseFragment<FragmentTransferInputBinding, TransferInputViewModel>() {
    override val mViewModel: TransferInputViewModel by inject()
    override val layoutRes: Int
        get() = R.layout.fragment_transfer_input

    override fun observerViewModel() {
        with(mViewModel){
            cancelBtn.observe(this@TransferInputFragment, Observer {
                requireActivity().finish()
            })

            backBtn.observe(this@TransferInputFragment, Observer {
                if (bankBookNumber.value?.length!! > 0) {
                    val str = bankBookNumber.value!!.substring(0, bankBookNumber.value!!.length - 1)
                    bankBookNumber.value = str
                }
            })

        }
    }
}