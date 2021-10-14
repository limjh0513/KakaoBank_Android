package kr.hs.dgsw.kakaobank.view.fragment.openup

import android.content.Intent
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import kr.hs.dgsw.kakaobank.R
import kr.hs.dgsw.kakaobank.base.BaseFragment
import kr.hs.dgsw.kakaobank.databinding.FragmentOpenupRePasswordBinding
import kr.hs.dgsw.kakaobank.view.activity.OpenUpSuccessActivity
import kr.hs.dgsw.kakaobank.viewmodel.openup.OpenupRePasswordViewModel
import org.koin.android.ext.android.inject


class OpenupRePasswordFragment : BaseFragment<FragmentOpenupRePasswordBinding, OpenupRePasswordViewModel>() {
    override val mViewModel: OpenupRePasswordViewModel by inject()
    override val layoutRes: Int
        get() = R.layout.fragment_openup_re_password

    override fun observerViewModel() {
        with(mViewModel){
            password.observe(this@OpenupRePasswordFragment, Observer {
                showSecretPassword(it.length)
                if (it.length == 4) {
                    val intent = Intent(requireActivity(), OpenUpSuccessActivity::class.java)
                    startActivity(intent)
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