package kr.hs.dgsw.kakaobank.view.fragment.openup

import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import kr.hs.dgsw.kakaobank.R
import kr.hs.dgsw.kakaobank.base.BaseFragment
import kr.hs.dgsw.kakaobank.databinding.FragmentOpenupInputBinding
import kr.hs.dgsw.kakaobank.view.activity.OpenUpSuccessActivity
import kr.hs.dgsw.kakaobank.viewmodel.openup.OpenupInputViewModel
import org.koin.android.ext.android.inject
import java.util.regex.Pattern


class OpenupInputFragment : BaseFragment<FragmentOpenupInputBinding, OpenupInputViewModel>() {
    override val mViewModel: OpenupInputViewModel by inject()
    override val layoutRes: Int
        get() = R.layout.fragment_openup_input


    private var check = IntArray(3)

    override fun observerViewModel() {
        with(mViewModel) {
            inputName.observe(this@OpenupInputFragment, Observer {
                if (it.length > 0) {
                    check[0] = 1;
                    isAvilableNextBtn()
                } else {
                    check[0] = 0;
                    isAvilableNextBtn()
                }
            })

            inputRegisterFront.observe(this@OpenupInputFragment, Observer {
                if (it.length == 6) {
                    if (isValidResident(it)) {
                        mBinding.openIEtResistBack.requestFocus()
                        if (inputRegisterBack.value?.length == 1) {
                            check[1] = 1;
                            isAvilableNextBtn()
                        }
                    } else {
                        inputRegisterFront.value = ""
                        Toast.makeText(requireContext(),
                            "잘못된 주민번호 앞자리를 입력했습니다.",
                            Toast.LENGTH_SHORT).show()
                        check[1] = 0;
                        isAvilableNextBtn()
                    }
                } else {
                    check[1] = 0;
                    isAvilableNextBtn()
                }
            })

            inputRegisterBack.observe(this@OpenupInputFragment, Observer {
                if (inputRegisterFront.value?.length == 6 && it.length == 1) {
                    check[1] = 1;
                    isAvilableNextBtn()
                } else {
                    check[1] = 0;
                    isAvilableNextBtn()
                }
            })

            positiveRadioBtn.observe(this@OpenupInputFragment, Observer {
                if (it) {
                    check[2] = 1;
                    isAvilableNextBtn()
                }
            })

            negativeRadioBtn.observe(this@OpenupInputFragment, Observer {
                if (it) {
                    check[2] = 0;
                    isAvilableNextBtn()
                }
            })
        }
    }

    fun isValidResident(number: String): Boolean {
        val ResidentPattern = "^([0-9]{2}(0[1-9]|1[0-2])(0[1-9]|[1,2][0-9]|3[0,1]))$"

        return Pattern.matches(ResidentPattern, number)
    }

    fun isAvilableNextBtn() {
        var result = true

        for (i in check) {
            if (i == 0) {
                result = false
                break
            }
        }

        if (result) {
            mBinding.openINextBtn.setBackgroundColor(ContextCompat.getColor(requireContext(),
                R.color.kakao))
            mBinding.openINextBtn.setTextColor(ContextCompat.getColor(requireContext(),
                R.color.text_mainColor))
            mBinding.openINextBtn.setOnClickListener {
                Log.e("dasfsdf", "${mViewModel.inputName.value}")
                val bundle = bundleOf("name" to mViewModel.inputName.value,
                    "residentNumber" to "${mViewModel.inputRegisterFront.value} - ${mViewModel.inputRegisterBack.value}******")
                this.findNavController()
                    .navigate(R.id.action_openupInputFragment_to_bankbookNickFragment, bundle)
            }
        } else {
            mBinding.openINextBtn.setBackgroundColor(ContextCompat.getColor(requireContext(),
                R.color.disabled))
            mBinding.openINextBtn.setTextColor(ContextCompat.getColor(requireContext(),
                R.color.disabled_text))
            mBinding.openINextBtn.setOnClickListener {
            }
        }


    }
}