package kr.hs.dgsw.kakaobank.view.fragment.signup

import android.app.Activity
import android.content.Intent
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import kr.hs.dgsw.kakaobank.R
import kr.hs.dgsw.kakaobank.base.BaseFragment
import kr.hs.dgsw.kakaobank.databinding.FragmentSignupSelectImgBinding
import kr.hs.dgsw.kakaobank.viewmodel.signup.SignupSelectImgViewModel
import org.koin.android.ext.android.inject

class SignupSelectImgFragment :
    BaseFragment<FragmentSignupSelectImgBinding, SignupSelectImgViewModel>() {
    override val mViewModel: SignupSelectImgViewModel by inject()
    override val layoutRes: Int
        get() = R.layout.fragment_signup_select_img

    private val OPEN_GALLARY: Int = 1

    override fun observerViewModel() {
        with(mViewModel) {
            imageSelectBtn.observe(this@SignupSelectImgFragment, Observer {
                val intent = Intent(Intent.ACTION_GET_CONTENT)
                intent.setType("image/*")
                startActivityForResult(intent, OPEN_GALLARY)
            })

            nextBtn.observe(this@SignupSelectImgFragment, Observer {
                this@SignupSelectImgFragment.findNavController().navigate(R.id.action_signupSelectImgFramgent_to_signupPasswordFramgent)
            })
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == Activity.RESULT_OK){
            if(requestCode == OPEN_GALLARY){
                var currentImageUri: Uri? = data?.data

                try{
                    currentImageUri.let{
                        if(Build.VERSION.SDK_INT< 28){
                            val bitmap = MediaStore.Images.Media.getBitmap(activity?.contentResolver, it)
                            mBinding.signupSProfileImage.setImageBitmap(bitmap)
                        } else {
                            val source = ImageDecoder.createSource(activity?.contentResolver!!, it!!)
                            val bitmap = ImageDecoder.decodeBitmap(source)
                            mBinding.signupSProfileImage.setImageBitmap(bitmap)
                        }
                    }
                } catch (e: Exception){
                    e.printStackTrace()
                }
            }
        } else if(requestCode == Activity.RESULT_CANCELED){
            Toast.makeText(requireContext(), "사진 선택 취소", Toast.LENGTH_SHORT).show()
        }
    }
}