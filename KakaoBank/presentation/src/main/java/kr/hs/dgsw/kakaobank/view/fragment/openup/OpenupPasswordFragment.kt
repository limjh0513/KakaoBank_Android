package kr.hs.dgsw.kakaobank.view.fragment.openup

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import kr.hs.dgsw.kakaobank.R
import kr.hs.dgsw.kakaobank.base.BaseFragment
import kr.hs.dgsw.kakaobank.databinding.FragmentOpenupPasswordBinding
import kr.hs.dgsw.kakaobank.view.activity.OpenUpSuccessActivity
import kr.hs.dgsw.kakaobank.viewmodel.openup.OpenupPasswordViewModel
import org.koin.android.ext.android.inject

class OpenupPasswordFragment :
    BaseFragment<FragmentOpenupPasswordBinding, OpenupPasswordViewModel>() {
    override val mViewModel: OpenupPasswordViewModel by inject()
    override val layoutRes: Int
        get() = R.layout.fragment_openup_password

    override fun observerViewModel() {
        with(mViewModel) {
            password.observe(this@OpenupPasswordFragment, Observer {
                showSecretPassword(it.length)
                if (it.length == 4) {
                    val bundle = bundleOf("password" to password.value)
                    this@OpenupPasswordFragment.findNavController().navigate(R.id.action_openupPasswordFragment_to_openupRePasswordFragment, bundle)
                }

            })
            passwordBackBtn.observe(this@OpenupPasswordFragment, Observer {
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
                mBinding.openupPPassword1.text = "*"
            }
            2 -> {
                mBinding.openupPPassword1.text = "*"
                mBinding.openupPPassword2.text = "*"
            }
            3 -> {
                mBinding.openupPPassword1.text = "*"
                mBinding.openupPPassword2.text = "*"
                mBinding.openupPPassword3.text = "*"
            }
            4 -> {
                mBinding.openupPPassword1.text = "*"
                mBinding.openupPPassword2.text = "*"
                mBinding.openupPPassword3.text = "*"
                mBinding.openupPPassword4.text = "*"
            }
        }
    }

    fun showInitPassword() {
        mBinding.openupPPassword1.text = ""
        mBinding.openupPPassword2.text = ""
        mBinding.openupPPassword3.text = ""
        mBinding.openupPPassword4.text = ""
    }

}