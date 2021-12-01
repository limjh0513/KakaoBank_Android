package kr.hs.dgsw.kakaobank.view.fragment.impor

import android.util.Log
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import kr.hs.dgsw.kakaobank.R
import kr.hs.dgsw.kakaobank.base.BaseFragment
import kr.hs.dgsw.kakaobank.databinding.FragmentImportMoneyBinding
import kr.hs.dgsw.kakaobank.view.activity.ImportActivity
import kr.hs.dgsw.kakaobank.viewmodel.impor.ImportMoneyViewModel
import kr.hs.dgsw.kakaobank.widget.getRestNumber
import org.koin.android.ext.android.inject

class ImportMoneyFragment : BaseFragment<FragmentImportMoneyBinding, ImportMoneyViewModel>() {
    override val mViewModel: ImportMoneyViewModel by inject()
    override val layoutRes: Int
        get() = R.layout.fragment_import_money

    override fun observerViewModel() {
        designAccountNumber()

        with(mViewModel) {
            cancelBtn.observe(this@ImportMoneyFragment, Observer {
                requireActivity().finish()
            })

            backBtn.observe(this@ImportMoneyFragment, Observer {
                if (importMoney.value?.length!! > 0) {
                    val str = importMoney.value!!.substring(0, importMoney.value!!.length - 1)
                    importMoney.value = str
                }
            })

            importMoney.observe(this@ImportMoneyFragment, Observer {
                if(it.length > 0){
                    mBinding.importMEtMoney.setText(getRestNumber(it))
                }
            })

            bankSubmitBtn.observe(this@ImportMoneyFragment, Observer {
                Log.e("dsf", "${importMoney.value}")
                if (importMoney.value != null) {
                    if (importMoney.value?.length!! > 0) {
                        (activity as ImportActivity).request.money =
                            Integer.parseInt(importMoney.value)

                        this@ImportMoneyFragment.findNavController()
                            .navigate(R.id.action_importMoneyFragment_to_importPasswordFragment)
                    }
                }
            })
        }
    }

    private fun designAccountNumber() {
        (activity as ImportActivity).request.fromAccountNum =
            arguments?.getString("accountNumber")
        (activity as ImportActivity).fromMoney = arguments?.getInt("money", 0)!!
        (activity as ImportActivity).fromNickName = arguments?.getString("nickname")!!

        mBinding.importMTvMain.text = "${(activity as ImportActivity).toNickName}(으)로 가져오기"
        mBinding.textView5.text = "${(activity as ImportActivity).fromNickName} : ${(activity as ImportActivity).fromMoney}원"

        mBinding.importMEtMoney.isFocusable = false
        mBinding.importMEtMoney.isClickable = false
    }
}