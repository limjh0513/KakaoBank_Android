package kr.hs.dgsw.kakaobank.view.fragment.transfer

import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.Observer
import kr.hs.dgsw.data.util.SharedPreferenceManager
import kr.hs.dgsw.kakaobank.R
import kr.hs.dgsw.kakaobank.base.BaseFragment
import kr.hs.dgsw.kakaobank.databinding.FragmentTransferPasswordBinding
import kr.hs.dgsw.kakaobank.view.activity.TransferActivity
import kr.hs.dgsw.kakaobank.view.activity.TransferSuccessActivity
import kr.hs.dgsw.kakaobank.viewmodel.transfer.TransferPasswordViewModel
import org.koin.android.ext.android.inject


class TransferPasswordFragment :
    BaseFragment<FragmentTransferPasswordBinding, TransferPasswordViewModel>() {
    override val mViewModel: TransferPasswordViewModel by inject()
    override val layoutRes: Int
        get() = R.layout.fragment_transfer_password

    override fun observerViewModel() {
        with(mViewModel) {
            cancelBtn.observe(this@TransferPasswordFragment, Observer {
                requireActivity().finish()
            })

            backBtn.observe(this@TransferPasswordFragment, Observer {
                if (password.value?.length!! > 0) {
                    val str = password.value!!.substring(0, password.value!!.length - 1)
                    password.value = str
                }
            })

            password.observe(this@TransferPasswordFragment, Observer {
                if (it.length == 4) {
                    checkPassword()
                }
            })

            loginSuccess.observe(this@TransferPasswordFragment, Observer {
                if (it) {
                    getTransferMoneyStart()
                } else {
                    password.value = ""
                    Toast.makeText(requireContext(), "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show()
                }
            })

            loginError.observe(this@TransferPasswordFragment, Observer {
                password.value = ""
                Toast.makeText(requireContext(),
                    "로그인 진행 중 문제가 발생했습니다. 다시 시도해주세요",
                    Toast.LENGTH_SHORT).show()
            })

            transferMoneySuccess.observe(this@TransferPasswordFragment, Observer {
                val intent = Intent(requireContext(), TransferSuccessActivity::class.java)
                intent.putExtra("from", (activity as TransferActivity).request.fromAccountNumber)
                intent.putExtra("to", (activity as TransferActivity).request.toAccountNumber)
                intent.putExtra("money",
                    (activity as TransferActivity).money)
                intent.putExtra("fees",
                    (activity as TransferActivity).fees)
                startActivity(intent)
                requireActivity().finish()
            })

            transferMoneyError.observe(this@TransferPasswordFragment, Observer {
                password.value = ""
                Toast.makeText(requireContext(), "계좌이체 진행 중 문제가 발생했습니다.", Toast.LENGTH_SHORT).show()
            })
        }
    }

    private fun getTransferMoneyStart() {
        var token: String? = SharedPreferenceManager.getToken(requireContext())

        if (token != null) {
            mViewModel.transferMoney("Bearer $token", (activity as TransferActivity).request)
        } else {
            Toast.makeText(requireContext(), "토큰이 존재하지 않습니다. 다시 로그인해주세요", Toast.LENGTH_SHORT).show()
            requireActivity().finish()
        }
    }

    private fun checkPassword() {

        var token: String? = SharedPreferenceManager.getToken(requireContext())

        if (token != null) {
            mViewModel.passwordCheck("Bearer $token",
                (activity as TransferActivity).request.fromAccountNumber!!,
                mViewModel.password.value!!)
        } else {
            Toast.makeText(requireContext(), "토큰이 존재하지 않습니다. 다시 로그인해주세요", Toast.LENGTH_SHORT).show()
            requireActivity().finish()
        }
    }

}