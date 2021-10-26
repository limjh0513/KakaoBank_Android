package kr.hs.dgsw.kakaobank.view.fragment.openup

import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import kr.hs.dgsw.data.util.SharedPreferenceManager
import kr.hs.dgsw.kakaobank.R
import kr.hs.dgsw.kakaobank.base.BaseFragment
import kr.hs.dgsw.kakaobank.databinding.FragmentOpenupRePasswordBinding
import kr.hs.dgsw.kakaobank.view.activity.OpenUpSuccessActivity
import kr.hs.dgsw.kakaobank.view.activity.OpenupActivity
import kr.hs.dgsw.kakaobank.viewmodel.openup.OpenupRePasswordViewModel
import org.koin.android.ext.android.inject


class OpenupRePasswordFragment :
    BaseFragment<FragmentOpenupRePasswordBinding, OpenupRePasswordViewModel>() {
    override val mViewModel: OpenupRePasswordViewModel by inject()
    override val layoutRes: Int
        get() = R.layout.fragment_openup_re_password

    var checkPw: String? = null

    override fun observerViewModel() {
        checkPw = arguments?.getString("password")

        with(mViewModel) {
            password.observe(this@OpenupRePasswordFragment, Observer {
                showSecretPassword(it.length)
                if (it.length == 4) {
                    if (checkPw!!.equals(it)) {
                        (activity as OpenupActivity).request.password = it
                        var token: String? = SharedPreferenceManager.getToken(requireContext())
                        this.insertAccount("Bearer $token", (activity as OpenupActivity).request)
                    } else {
                        Toast.makeText(requireContext(), "비밀번호를 잘못 입력했습니다.", Toast.LENGTH_SHORT)
                            .show()
                        this@OpenupRePasswordFragment.findNavController()
                            .navigate(R.id.action_openupRePasswordFragment_to_openupPasswordFragment)
                    }
                }

            })
            passwordBackBtn.observe(this@OpenupRePasswordFragment, Observer {
                if (password.value?.length!! > 0) {
                    val str = password.value!!.substring(0, password.value!!.length - 1)
                    password.value = str
                    showInitPassword()
                    showSecretPassword(password.value!!.length)
                }
            })

            insertSuccess.observe(this@OpenupRePasswordFragment, Observer {
                val intent = Intent(requireActivity(), OpenUpSuccessActivity::class.java)
                startActivity(intent)
                requireActivity().finish()
            })

            insertFail.observe(this@OpenupRePasswordFragment, Observer {
                Toast.makeText(requireContext(), "계좌 생성 중 문제가 발생했습니다.", Toast.LENGTH_SHORT).show()
            })
        }
    }

    fun showSecretPassword(cnt: Int) {
        when (cnt) {
            1 -> {
                mBinding.openupRPassword1.text = "*"
            }
            2 -> {
                mBinding.openupRPassword1.text = "*"
                mBinding.openupRPassword2.text = "*"
            }
            3 -> {
                mBinding.openupRPassword1.text = "*"
                mBinding.openupRPassword2.text = "*"
                mBinding.openupRPassword3.text = "*"
            }
            4 -> {
                mBinding.openupRPassword1.text = "*"
                mBinding.openupRPassword2.text = "*"
                mBinding.openupRPassword3.text = "*"
                mBinding.openupRPassword4.text = "*"
            }
        }
    }

    fun showInitPassword() {
        mBinding.openupRPassword1.text = ""
        mBinding.openupRPassword2.text = ""
        mBinding.openupRPassword3.text = ""
        mBinding.openupRPassword4.text = ""
    }

}