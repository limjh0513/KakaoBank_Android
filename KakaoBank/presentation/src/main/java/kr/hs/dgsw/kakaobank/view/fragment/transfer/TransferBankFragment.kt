package kr.hs.dgsw.kakaobank.view.fragment.transfer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kr.hs.dgsw.kakaobank.R
import kr.hs.dgsw.kakaobank.databinding.FragmentTransferBankBinding
import kr.hs.dgsw.kakaobank.viewmodel.transfer.TransferBankViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

class TransferBankFragment : BottomSheetDialogFragment() {

    lateinit var mBinding: FragmentTransferBankBinding
    lateinit var mViewModel: TransferBankViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.CustomBottomSheetDialogTheme)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        mBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_transfer_bank, container, false)
        mViewModel = ViewModelProvider(this).get(TransferBankViewModel::class.java)

        mBinding.lifecycleOwner = this
        mBinding.vm = mViewModel

        observeViewModel()

        return mBinding.root
    }

    private fun observeViewModel() {
        with(mViewModel){
            backBtn.observe(this@TransferBankFragment, Observer {
                dismiss()
            })

            kakaoBankBtn.observe(this@TransferBankFragment, Observer {
                val bankBundle: Bundle = Bundle()
                bankBundle.putInt("bankNumber", 2)
                dismiss()
            })

            tossBankBtn.observe(this@TransferBankFragment, Observer {
                val bankBundle: Bundle = Bundle()
                bankBundle.putInt("bankNumber", 1)
                dismiss()
            })

            deaguBankBtn.observe(this@TransferBankFragment, Observer {
                val bankBundle: Bundle = Bundle()
                bankBundle.putInt("bankNumber", 4)
                dismiss()
            })

            kBankBtn.observe(this@TransferBankFragment, Observer {
                val bankBundle: Bundle = Bundle()
                bankBundle.putInt("bankNumber", 3)
                dismiss()
            })

            busanBankBtn.observe(this@TransferBankFragment, Observer {
                val bankBundle: Bundle = Bundle()
                bankBundle.putInt("bankNumber", 5)
                dismiss()
            })
        }
    }


}