package kr.hs.dgsw.kakaobank.view.fragment.other

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import kr.hs.dgsw.kakaobank.R
import kr.hs.dgsw.kakaobank.base.BaseFragment
import kr.hs.dgsw.kakaobank.databinding.FragmentOtherTermsBinding
import kr.hs.dgsw.kakaobank.viewmodel.other.OtherTermsViewModel
import org.koin.android.ext.android.inject


class OtherTermsFragment : BaseFragment<FragmentOtherTermsBinding, OtherTermsViewModel>() {
    override val mViewModel: OtherTermsViewModel by inject()
    override val layoutRes: Int
        get() = R.layout.fragment_other_terms

    override fun observerViewModel() {
        with(mViewModel){
            isChecked.observe(this@OtherTermsFragment, Observer {
                if (it) {
                    mBinding.otherTNextBtn.setBackgroundColor(ContextCompat.getColor(requireContext(),
                        R.color.kakao))
                    mBinding.otherTNextBtn.setTextColor(ContextCompat.getColor(requireContext(),
                        R.color.text_mainColor))
                    mBinding.otherTNextBtn.setOnClickListener {
                        this@OtherTermsFragment.findNavController()
                            .navigate(R.id.action_otherTermsFragment_to_otherSelectFragment)
                    }
                } else {
                    mBinding.otherTNextBtn.setBackgroundColor(ContextCompat.getColor(requireContext(),
                        R.color.disabled))
                    mBinding.otherTNextBtn.setTextColor(ContextCompat.getColor(requireContext(),
                        R.color.disabled_text))
                    mBinding.otherTNextBtn.setOnClickListener {
                    }
                }
            })

            termsShowBtn.observe(this@OtherTermsFragment, Observer {
                val intent =
                    Intent(Intent.ACTION_VIEW, Uri.parse("https://img.shinhan.com/sbank2016/yak/900000007_yak_20201210192646.pdf?1607596008610"))
                startActivity(intent)
            })
        }
    }

}