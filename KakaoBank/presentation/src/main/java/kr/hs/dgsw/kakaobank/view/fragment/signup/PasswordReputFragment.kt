package kr.hs.dgsw.kakaobank.view.fragment.signup

import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import kr.hs.dgsw.kakaobank.R
import kr.hs.dgsw.kakaobank.base.BaseFragment
import kr.hs.dgsw.kakaobank.databinding.FragmentPasswordReputBinding
import kr.hs.dgsw.kakaobank.view.activity.SignupActivity
import kr.hs.dgsw.kakaobank.view.activity.WelcomeActivity
import kr.hs.dgsw.kakaobank.viewmodel.signup.PasswordReputViewModel
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.Request
import okhttp3.RequestBody
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
                    if ((activity as SignupActivity).request.simpleNumber!! == Integer.parseInt(it)) {
                        mViewModel.signUp((activity as SignupActivity).request, null)
                    } else {
                        Toast.makeText(requireContext(),
                            "비밀번호를 잘못 입력했습니다. 다시 설정해주세요.",
                            Toast.LENGTH_SHORT).show()
                        this@PasswordReputFragment.findNavController()
                            .navigate(R.id.action_passwordReputFragment_to_signupPasswordFramgent)
                    }

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

            onErrorEvent.observe(this@PasswordReputFragment, Observer {
                Toast.makeText(requireContext(),
                    "회원가입 정보를 전송하지 못했습니다. 다시 시도해주세요",
                    Toast.LENGTH_SHORT).show()
            })

            onSuccessEvent.observe(this@PasswordReputFragment, Observer {
                val intent = Intent(requireContext(), WelcomeActivity::class.java)
                intent.putExtra("userName", mViewModel.userName.value)
                startActivity(intent)
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