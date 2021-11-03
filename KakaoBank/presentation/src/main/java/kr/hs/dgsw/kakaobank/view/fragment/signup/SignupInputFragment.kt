package kr.hs.dgsw.kakaobank.view.fragment.signup

import android.annotation.SuppressLint
import android.text.Layout
import androidx.lifecycle.Observer
import kr.hs.dgsw.kakaobank.R
import kr.hs.dgsw.kakaobank.base.BaseFragment
import kr.hs.dgsw.kakaobank.databinding.FragmentSignupInputBinding
import kr.hs.dgsw.kakaobank.viewmodel.signup.SignupInputViewModel
import org.koin.android.ext.android.inject
import java.util.*
import java.util.regex.Pattern
import android.util.Log
import android.view.MotionEvent
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import kr.hs.dgsw.domain.request.RegisterRequest
import kr.hs.dgsw.kakaobank.view.activity.SignupActivity
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignupInputFragment : BaseFragment<FragmentSignupInputBinding, SignupInputViewModel>() {
    override val mViewModel: SignupInputViewModel by inject()
    override val layoutRes: Int
        get() = R.layout.fragment_signup_input

    private var imageCheck = IntArray(6)

    override fun observerViewModel() {
        with(mViewModel) {
            overlapCheckBtn.observe(this@SignupInputFragment, Observer {
                if (isValidId(inputId.value.toString())) { //아이디 정규식 확인
                    //아이디 중복 체크
                    mViewModel.checkAvailableId()
                } else {
                    imageCheck[0] = 0
                    Toast.makeText(requireContext(), "아이디 형식이 맞지 않습니다.", Toast.LENGTH_SHORT).show()
                    mBinding.idCheckImg.setImageResource(R.drawable.is_cancel)
                }
            })

            inputPw.observe(this@SignupInputFragment, Observer {
                if (isValidPw(it.toString())) {
                    mBinding.pwCheckImg.setImageResource(R.drawable.is_checked)
                    imageCheck[1] = 1
                    isAvilableNextBtn()
                    passwordReputCheck()
                } else {
                    mBinding.pwCheckImg.setImageResource(R.drawable.is_cancel)
                    imageCheck[1] = 0
                    isAvilableNextBtn()
                    passwordReputCheck()
                }
            })

            inputPwAgain.observe(this@SignupInputFragment, Observer {
                passwordReputCheck()
            })

            inputPhoneNumber.observe(this@SignupInputFragment, Observer {
                if (it.length == 11) {
                    inputPhoneNumber.value = "${isValidPhoneNumber(it)}"
                    Log.e("123", isValidPhoneNumber(it))
                    mBinding.phoneCheckImg.setImageResource(R.drawable.is_checked)
                    mBinding.signupIPhoneEdText.clearFocus()
                    imageCheck[3] = 1
                    isAvilableNextBtn()
                } else if (it.length == 12) {
                    inputPhoneNumber.value = ""
                    mBinding.phoneCheckImg.setImageResource(R.drawable.is_cancel)
                    imageCheck[3] = 0
                    isAvilableNextBtn()
                } else if (it.length == 13) {
                    isAvilableNextBtn()
                    mBinding.signupINicknameEdText.requestFocus()
                }
            })

            inputNickName.observe(this@SignupInputFragment, Observer {
                if (it.length >= 2) {
                    mBinding.nicknameCheckImg.setImageResource(R.drawable.is_checked)
                    imageCheck[4] = 1
                    isAvilableNextBtn()
                } else {
                    mBinding.nicknameCheckImg.setImageResource(R.drawable.is_cancel)
                    imageCheck[4] = 0
                    isAvilableNextBtn()
                }
            })

            residentFrontNumber.observe(this@SignupInputFragment, Observer {
                if (it.length == 6) {
                    if (isValidResident(it)) {
                        mBinding.signupIRegistNumEdText2.requestFocus()
                        if (residentFrontNumber.value?.length == 6 && residentBackNumber.value?.length == 1) {
                            mBinding.registNumCheckImg.setImageResource(R.drawable.is_checked)
                            imageCheck[5] = 1
                        }
                        isAvilableNextBtn()
                    } else {
                        residentFrontNumber.value = ""
                        Toast.makeText(requireContext(),
                            "잘못된 주민번호 앞자리를 입력했습니다.",
                            Toast.LENGTH_SHORT).show()
                        imageCheck[5] = 0
                        isAvilableNextBtn()
                    }
                } else {
                    mBinding.registNumCheckImg.setImageResource(R.drawable.is_cancel)
                    imageCheck[5] = 0
                    isAvilableNextBtn()
                }
            })

            residentBackNumber.observe(this@SignupInputFragment, Observer {
                if (!it.equals("")) {
                    val numberParseInt = Integer.parseInt(it)
                    if (numberParseInt in 1..4) {
                        if (residentFrontNumber.value?.length == 6 && it.length == 1) {
                            mBinding.registNumCheckImg.setImageResource(R.drawable.is_checked)
                            imageCheck[5] = 1
                            isAvilableNextBtn()
                        } else {
                            mBinding.registNumCheckImg.setImageResource(R.drawable.is_cancel)
                            imageCheck[5] = 0
                            isAvilableNextBtn()
                        }
                    } else {
                        Toast.makeText(requireContext(),
                            "잘못된 주민번호 뒷자리를 입력했습니다.",
                            Toast.LENGTH_SHORT).show()
                        residentBackNumber.value = ""
                        imageCheck[5] = 0
                        isAvilableNextBtn()
                    }
                }
            })

            onAvailableErrorEvent.observe(this@SignupInputFragment, Observer {
                Toast.makeText(requireContext(), "아이디 중복확인 중 문제가 발생했습니다.", Toast.LENGTH_SHORT)
                    .show()
            })

            onAvailableSuccessEvent.observe(this@SignupInputFragment, Observer {
                Log.e("aaaaa", "${it}")
                if (it) {
                    imageCheck[0] = 1
                    mBinding.idCheckImg.setImageResource(R.drawable.is_checked)
                } else {
                    imageCheck[0] = 0
                    Toast.makeText(requireContext(), "아이디가 중복되었습니다.", Toast.LENGTH_SHORT).show()
                    mBinding.idCheckImg.setImageResource(R.drawable.is_cancel)
                }
            })
        }
    }

    fun passwordReputCheck() {
        if (mViewModel.inputPwAgain.value.toString() == mViewModel.inputPw.value.toString()) {
            mBinding.repwCheckImg.setImageResource(R.drawable.is_checked)
            imageCheck[2] = 1
            isAvilableNextBtn()
        } else {
            mBinding.repwCheckImg.setImageResource(R.drawable.is_cancel)
            imageCheck[2] = 0
            isAvilableNextBtn()
        }
    }

    fun isAvilableNextBtn() {
        var result = true

        for (i in imageCheck) {
            if (i == 0) {
                result = false
                break
            }
        }

        if (result) {
            mBinding.signupINextBtn.setBackgroundColor(ContextCompat.getColor(requireContext(),
                R.color.kakao))
            mBinding.signupINextBtn.setTextColor(ContextCompat.getColor(requireContext(),
                R.color.text_mainColor))
            mBinding.signupINextBtn.setOnClickListener {
                val residentNum =
                    "${mViewModel.residentBackNumber.value}${mViewModel.residentBackNumber.value}"

                (activity as SignupActivity).request.id = mViewModel.inputId.value
                (activity as SignupActivity).request.name = mViewModel.inputName.value
                (activity as SignupActivity).request.nickName = mViewModel.inputNickName.value
                (activity as SignupActivity).request.password = mViewModel.inputPw.value
                (activity as SignupActivity).request.phoneNumber = mViewModel.inputPhoneNumber.value
                (activity as SignupActivity).request.residentRegistrationNumber = residentNum

                this@SignupInputFragment.findNavController()
                    .navigate(R.id.action_signup_input_to_signupSelectImgFramgent)
            }
        } else {
            mBinding.signupINextBtn.setBackgroundColor(ContextCompat.getColor(requireContext(),
                R.color.disabled))
            mBinding.signupINextBtn.setTextColor(ContextCompat.getColor(requireContext(),
                R.color.disabled_text))
            mBinding.signupINextBtn.setOnClickListener {
            }
        }
    }

    fun isValidId(id: String?): Boolean {
        val idPattern = "^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z[0-9]]{3,12}$"

        return Pattern.matches(idPattern, id)
    }

    fun isValidPw(pw: String?): Boolean {
        val pwPattern = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z[0-9]$@$!%*#?&]{8,10}$"

        return Pattern.matches(pwPattern, pw)
    }

    fun isValidPhoneNumber(number: String): String {
        val first = number.slice(IntRange(0, 2))
        val second = number.slice(IntRange(3, 6))
        val last = number.slice(IntRange(7, 10))
        return "$first-$second-$last"
    }

    fun isValidResident(number: String): Boolean {
        val ResidentPattern = "^([0-9]{2}(0[1-9]|1[0-2])(0[1-9]|[1,2][0-9]|3[0,1]))$"

        return Pattern.matches(ResidentPattern, number)
    }
}