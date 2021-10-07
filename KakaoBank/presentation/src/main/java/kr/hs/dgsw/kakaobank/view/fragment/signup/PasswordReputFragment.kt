package kr.hs.dgsw.kakaobank.view.fragment.signup

import android.content.Intent
import android.util.Log
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import kr.hs.dgsw.kakaobank.R
import kr.hs.dgsw.kakaobank.base.BaseFragment
import kr.hs.dgsw.kakaobank.databinding.FragmentPasswordReputBinding
import kr.hs.dgsw.kakaobank.view.activity.WelcomeActivity
import kr.hs.dgsw.kakaobank.viewmodel.signup.PasswordReputViewModel
import org.koin.android.ext.android.inject


class PasswordReputFragment : BaseFragment<FragmentPasswordReputBinding, PasswordReputViewModel>() {
    override val mViewModel: PasswordReputViewModel by inject()
    override val layoutRes: Int
        get() = R.layout.fragment_password_reput

    override fun observerViewModel() {
        with(mViewModel) {
            password.observe(this@PasswordReputFragment, Observer {
                showSecretPassword(it.length)
                if (it.length == 6) {
                    val intent = Intent(requireActivity(), WelcomeActivity::class.java)
                    startActivity(intent)
                }
            })

            passwordBackBtn.observe(this@PasswordReputFragment, Observer {
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
                mBinding.signupRPassword1.text = "*"
            }
            2 -> {
                mBinding.signupRPassword1.text = "*"
                mBinding.signupRPassword2.text = "*"
            }
            3 -> {
                mBinding.signupRPassword1.text = "*"
                mBinding.signupRPassword2.text = "*"
                mBinding.signupRPassword3.text = "*"
            }
            4 -> {
                mBinding.signupRPassword1.text = "*"
                mBinding.signupRPassword2.text = "*"
                mBinding.signupRPassword3.text = "*"
                mBinding.signupRPassword4.text = "*"
            }
            5 -> {
                mBinding.signupRPassword1.text = "*"
                mBinding.signupRPassword2.text = "*"
                mBinding.signupRPassword3.text = "*"
                mBinding.signupRPassword4.text = "*"
                mBinding.signupRPassword5.text = "*"
            }
            6 -> {
                mBinding.signupRPassword1.text = "*"
                mBinding.signupRPassword2.text = "*"
                mBinding.signupRPassword3.text = "*"
                mBinding.signupRPassword4.text = "*"
                mBinding.signupRPassword5.text = "*"
                mBinding.signupRPassword6.text = "*"
            }
        }
    }

    fun showInitPassword() {
        mBinding.signupRPassword1.text = ""
        mBinding.signupRPassword2.text = ""
        mBinding.signupRPassword3.text = ""
        mBinding.signupRPassword4.text = ""
        mBinding.signupRPassword5.text = ""
        mBinding.signupRPassword6.text = ""
    }

}