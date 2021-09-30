package kr.hs.dgsw.kakaobank.view.fragment.signup

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import kr.hs.dgsw.kakaobank.R
import kr.hs.dgsw.kakaobank.base.BaseFragment
import kr.hs.dgsw.kakaobank.databinding.FragmentSignupTermsBinding
import kr.hs.dgsw.kakaobank.viewmodel.signup.SignupTermsViewModel
import org.koin.android.ext.android.inject

class SignupTermsFragment : BaseFragment<FragmentSignupTermsBinding, SignupTermsViewModel>() {
    override val mViewModel: SignupTermsViewModel by inject()
    override val layoutRes: Int
        get() = R.layout.fragment_signup_terms


    @SuppressLint("ResourceAsColor")
    override fun observerViewModel() {
        with(mViewModel){
            termsIsCheck.observe(this@SignupTermsFragment, Observer{
                Log.d("text", "${it} ${mBinding.signTNextBtn.background}" )
                if(it){
                    mBinding.signTNextBtn.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.kakao))
                    mBinding.signTNextBtn.setTextColor(ContextCompat.getColor(requireContext(), R.color.text_mainColor))
                    mBinding.signTNextBtn.setOnClickListener {
                        this@SignupTermsFragment.findNavController().navigate(R.id.action_signup_terms_to_signup_input)
                    }
                } else{
                    mBinding.signTNextBtn.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.disabled))
                    mBinding.signTNextBtn.setTextColor(ContextCompat.getColor(requireContext(), R.color.disabled_text))
                    mBinding.signTNextBtn.setOnClickListener {
                    }
                }
            })

            firstPolicy.observe(this@SignupTermsFragment, Observer {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://m.kakaobank.com/ServicePolicy"))
                startActivity(intent)
            })

            secondPolicy.observe(this@SignupTermsFragment, Observer {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://m.kakaobank.com/EBankingPolicy"))
                startActivity(intent)
            })
        }
    }
}