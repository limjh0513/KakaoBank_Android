package kr.hs.dgsw.kakaobank.view.fragment.impor

import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import kr.hs.dgsw.data.util.SharedPreferenceManager
import kr.hs.dgsw.kakaobank.R
import kr.hs.dgsw.kakaobank.base.BaseFragment
import kr.hs.dgsw.kakaobank.databinding.FragmentImportPasswordBinding
import kr.hs.dgsw.kakaobank.view.activity.ImportActivity
import kr.hs.dgsw.kakaobank.view.activity.ImportSuccessActivity
import kr.hs.dgsw.kakaobank.viewmodel.impor.ImportPasswordViewModel
import org.koin.android.ext.android.inject


class ImportPasswordFragment :
    BaseFragment<FragmentImportPasswordBinding, ImportPasswordViewModel>() {
    override val mViewModel: ImportPasswordViewModel by inject()
    override val layoutRes: Int
        get() = R.layout.fragment_import_password

    override fun observerViewModel() {
        with(mViewModel) {
            cancelBtn.observe(this@ImportPasswordFragment, Observer {
                requireActivity().finish()
            })

            backBtn.observe(this@ImportPasswordFragment, Observer {
                if (password.value?.length!! > 0) {
                    val str = password.value!!.substring(0, password.value!!.length - 1)
                    password.value = str
                    showInitPassword()
                    showSecretPassword(password.value!!.length)
                }
            })

            password.observe(this@ImportPasswordFragment, Observer {
                Log.e("it", "${it}")
                showSecretPassword(password.value!!.length)
                if (it.length == 4) {
                    checkPassword()
                }
            })

            loginSuccess.observe(this@ImportPasswordFragment, Observer {
                if (it) {
                    getImportStart()
                } else {
                    password.value = ""
                    Toast.makeText(requireContext(), "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show()
                }
            })

            loginError.observe(this@ImportPasswordFragment, Observer {
                password.value = ""
                Toast.makeText(requireContext(),
                    "로그인 진행 중 문제가 발생했습니다. 다시 시도해주세요",
                    Toast.LENGTH_SHORT).show()
            })

            importMoneySuccess.observe(this@ImportPasswordFragment, Observer {
                val intent = Intent(requireContext(), ImportSuccessActivity::class.java)
                startActivity(intent)
                requireActivity().finish()
            })

            importMoneyError.observe(this@ImportPasswordFragment, Observer {
                password.value = ""
                Toast.makeText(requireContext(),
                    "가져오기 진행 중 문제가 발생했습니다. 다시 시도해주세요",
                    Toast.LENGTH_SHORT).show()
            })
        }
    }

    private fun getImportStart() {
        var token: String? = SharedPreferenceManager.getToken(requireContext())

        if (token != null) {
            mViewModel.importMoney("Bearer $token", (activity as ImportActivity).request)
        } else {
            Toast.makeText(requireContext(), "토큰이 존재하지 않습니다. 다시 로그인해주세요", Toast.LENGTH_SHORT).show()
            requireActivity().finish()
        }
    }

    private fun checkPassword() {
        var token: String? = SharedPreferenceManager.getToken(requireContext())
        val account = (activity as ImportActivity).request.fromAccountNum

        if (token != null) {
            mViewModel.passwordCheck("Bearer $token",
                account!!,
                mViewModel.password.value!!)
        } else {
            Toast.makeText(requireContext(), "토큰이 존재하지 않습니다. 다시 로그인해주세요", Toast.LENGTH_SHORT).show()
            requireActivity().finish()
        }
    }

    fun showSecretPassword(cnt: Int) {
        when (cnt) {
            1 -> {
                mBinding.importPwPassword1.text = "*"
            }
            2 -> {
                mBinding.importPwPassword1.text = "*"
                mBinding.importPwPassword2.text = "*"
            }
            3 -> {
                mBinding.importPwPassword1.text = "*"
                mBinding.importPwPassword2.text = "*"
                mBinding.importPwPassword3.text = "*"
            }
            4 -> {
                mBinding.importPwPassword1.text = "*"
                mBinding.importPwPassword2.text = "*"
                mBinding.importPwPassword3.text = "*"
                mBinding.importPwPassword4.text = "*"
            }
        }
    }

    fun showInitPassword() {
        mBinding.importPwPassword1.text = ""
        mBinding.importPwPassword2.text = ""
        mBinding.importPwPassword3.text = ""
        mBinding.importPwPassword4.text = ""
    }


}