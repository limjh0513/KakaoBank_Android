package kr.hs.dgsw.kakaobank.view.fragment.impor

import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import kr.hs.dgsw.data.util.SharedPreferenceManager
import kr.hs.dgsw.domain.model.Account
import kr.hs.dgsw.kakaobank.R
import kr.hs.dgsw.kakaobank.base.BaseFragment
import kr.hs.dgsw.kakaobank.databinding.FragmentImportSelectBinding
import kr.hs.dgsw.kakaobank.view.activity.ImportActivity
import kr.hs.dgsw.kakaobank.viewmodel.impor.ImportSelectViewModel
import kr.hs.dgsw.kakaobank.widget.adapter.AccountImportItemAdapter
import org.koin.android.ext.android.inject
import java.util.ArrayList


class ImportSelectFragment : BaseFragment<FragmentImportSelectBinding, ImportSelectViewModel>() {
    override val mViewModel: ImportSelectViewModel by inject()
    override val layoutRes: Int
        get() = R.layout.fragment_import_select

    override fun observerViewModel() {
        getAccount()
        with(mViewModel){
            onErrorEvent.observe(this@ImportSelectFragment, Observer {
                Toast.makeText(requireContext(), "계좌 목록을 받아오지 못했습니다...", Toast.LENGTH_SHORT).show()
            })

            onSuccessEvent.observe(this@ImportSelectFragment, Observer {
                val accountList = currentAccountDelete(it)

                if(accountList.size <= 0){
                    mBinding.importSViewHint.visibility = View.VISIBLE
                } else {
                    mBinding.importSViewHint.visibility = View.INVISIBLE
                }

                val accountImportItemAdapter = AccountImportItemAdapter()

                accountImportItemAdapter.items = it
                accountImportItemAdapter.context = requireContext()

                mBinding.importSRecyclerview.adapter = accountImportItemAdapter
            })

            cancelBtn.observe(this@ImportSelectFragment, Observer {
                requireActivity().finish()
            })
        }
    }

    private fun currentAccountDelete(accounts: List<Account>?): List<Account> {
        val currentNumber = (activity as ImportActivity).accountNumber
        var accountList: ArrayList<Account> = ArrayList<Account>()

        if (accounts != null) {
            for (account in accounts) {
                if (!account.accountNumber.equals(currentNumber)) {
                    accountList.add(account)
                }
            }
        }

        return accountList.toList()
    }


    private fun getAccount() {
        var token: String? = SharedPreferenceManager.getToken(requireContext())

        if (token != null) {
            mViewModel.getAccountList("Bearer $token")
        } else {
            Toast.makeText(requireContext(), "토큰이 존재하지 않습니다. 다시 로그인해주세요", Toast.LENGTH_SHORT).show()
            requireActivity().finish()
        }
    }

}