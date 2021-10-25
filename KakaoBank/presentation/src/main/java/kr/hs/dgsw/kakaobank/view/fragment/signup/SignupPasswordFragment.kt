package kr.hs.dgsw.kakaobank.view.fragment.signup

import android.util.Log
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import kr.hs.dgsw.kakaobank.R
import kr.hs.dgsw.kakaobank.base.BaseFragment
import kr.hs.dgsw.kakaobank.databinding.FragmentSignupPasswordBinding
import kr.hs.dgsw.kakaobank.view.activity.SignupActivity
import kr.hs.dgsw.kakaobank.viewmodel.signup.SignupPasswordViewModel
import org.koin.android.ext.android.inject

class SignupPasswordFragment :
    BaseFragment<FragmentSignupPasswordBinding, SignupPasswordViewModel>() {
    override val mViewModel: SignupPasswordViewModel by inject()
    override val layoutRes: Int
        get() = R.layout.fragment_signup_password

    override fun observerViewModel() {
        with(mViewModel) {
            password.observe(this@SignupPasswordFragment, Observer {
                showSecretPassword(it.length)
                if (it.length == 6) {
                    (activity as SignupActivity).request.simpleNumber = Integer.parseInt(it)
                    this@SignupPasswordFragment.findNavController()
                        .navigate(R.id.action_signupPasswordFramgent_to_passwordReputFragment)
                }
            })

            passwordBackBtn.observe(this@SignupPasswordFragment, Observer {
                if (password.value?.length!! > 0) {
                    val str = password.value!!.substring(0, password.value!!.length - 1)
                    password.value = str
                    showInitPassword()
                    Log.e("afds", "${password.value!!.length} ${password.value!!}")
                    showSecretPassword(password.value!!.length)
                }
            })
        }
    }

    fun showSecretPassword(cnt: Int) {
        when (cnt) {
            1 -> {
                mBinding.signupPPassword1.text = "*"
            }
            2 -> {
                mBinding.signupPPassword1.text = "*"
                mBinding.signupPPassword2.text = "*"
            }
            3 -> {
                mBinding.signupPPassword1.text = "*"
                mBinding.signupPPassword2.text = "*"
                mBinding.signupPPassword3.text = "*"
            }
            4 -> {
                mBinding.signupPPassword1.text = "*"
                mBinding.signupPPassword2.text = "*"
                mBinding.signupPPassword3.text = "*"
                mBinding.signupPPassword4.text = "*"
            }
            5 -> {
                mBinding.signupPPassword1.text = "*"
                mBinding.signupPPassword2.text = "*"
                mBinding.signupPPassword3.text = "*"
                mBinding.signupPPassword4.text = "*"
                mBinding.signupPPassword5.text = "*"
            }
            6 -> {
                mBinding.signupPPassword1.text = "*"
                mBinding.signupPPassword2.text = "*"
                mBinding.signupPPassword3.text = "*"
                mBinding.signupPPassword4.text = "*"
                mBinding.signupPPassword5.text = "*"
                mBinding.signupPPassword6.text = "*"
            }
        }
    }

    fun showInitPassword() {
        mBinding.signupPPassword1.text = ""
        mBinding.signupPPassword2.text = ""
        mBinding.signupPPassword3.text = ""
        mBinding.signupPPassword4.text = ""
        mBinding.signupPPassword5.text = ""
        mBinding.signupPPassword6.text = ""
    }
}