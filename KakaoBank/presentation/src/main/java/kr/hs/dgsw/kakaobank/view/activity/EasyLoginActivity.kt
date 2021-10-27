package kr.hs.dgsw.kakaobank.view.activity

import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import kr.hs.dgsw.data.util.SharedPreferenceManager
import kr.hs.dgsw.kakaobank.R
import kr.hs.dgsw.kakaobank.base.BaseActivity
import kr.hs.dgsw.kakaobank.databinding.ActivityEasyLoginBinding
import kr.hs.dgsw.kakaobank.viewmodel.EasyLoginViewModel
import org.koin.android.ext.android.inject

class EasyLoginActivity : BaseActivity<ActivityEasyLoginBinding, EasyLoginViewModel>() {
    override val mViewModel: EasyLoginViewModel by inject()
    override val layoutRes: Int
        get() = R.layout.activity_easy_login

    override fun observerViewModel() {
        with(mViewModel) {
            backBtn.observe(this@EasyLoginActivity, Observer {
                finish()
            })

            password.observe(this@EasyLoginActivity, Observer {
                showSecretPassword(it.length)
                if (it.length == 6) {
                    mViewModel.easyLogin(SharedPreferenceManager.getToken(this@EasyLoginActivity)!!,
                        Integer.parseInt(it))
                }
            })

            passwordBackBtn.observe(this@EasyLoginActivity, Observer {
                if (password.value?.length!! > 0) {
                    val str = password.value!!.substring(0, password.value!!.length - 1)
                    password.value = str
                    showInitPassword()
                    Log.e("afds", "${password.value!!.length} ${password.value!!}")
                    showSecretPassword(password.value!!.length)
                }
            })

            easyLoginSuccess.observe(this@EasyLoginActivity, Observer {
                val intent = Intent(this@EasyLoginActivity, MainActivity::class.java)
                startActivity(intent)
            })

            easyLoginFail.observe(this@EasyLoginActivity, Observer {
                Toast.makeText(this@EasyLoginActivity,
                    "로그인에 실패했습니다. 비밀번호가 일치하지 않거나 네트워크 오류",
                    Toast.LENGTH_SHORT).show()
            })
        }
    }

    fun showSecretPassword(cnt: Int) {
        when (cnt) {
            1 -> {
                mBinding.easyLPassword1.text = "*"
            }
            2 -> {
                mBinding.easyLPassword1.text = "*"
                mBinding.easyLPassword2.text = "*"
            }
            3 -> {
                mBinding.easyLPassword1.text = "*"
                mBinding.easyLPassword2.text = "*"
                mBinding.easyLPassword3.text = "*"
            }
            4 -> {
                mBinding.easyLPassword1.text = "*"
                mBinding.easyLPassword2.text = "*"
                mBinding.easyLPassword3.text = "*"
                mBinding.easyLPassword4.text = "*"
            }
            5 -> {
                mBinding.easyLPassword1.text = "*"
                mBinding.easyLPassword2.text = "*"
                mBinding.easyLPassword3.text = "*"
                mBinding.easyLPassword4.text = "*"
                mBinding.easyLPassword5.text = "*"
            }
            6 -> {
                mBinding.easyLPassword1.text = "*"
                mBinding.easyLPassword2.text = "*"
                mBinding.easyLPassword3.text = "*"
                mBinding.easyLPassword4.text = "*"
                mBinding.easyLPassword5.text = "*"
                mBinding.easyLPassword6.text = "*"
            }
        }
    }

    fun showInitPassword() {
        mBinding.easyLPassword1.text = ""
        mBinding.easyLPassword2.text = ""
        mBinding.easyLPassword3.text = ""
        mBinding.easyLPassword4.text = ""
        mBinding.easyLPassword5.text = ""
        mBinding.easyLPassword6.text = ""
    }

}