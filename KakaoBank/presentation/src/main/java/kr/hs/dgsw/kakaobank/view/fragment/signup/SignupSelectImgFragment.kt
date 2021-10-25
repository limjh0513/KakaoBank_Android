package kr.hs.dgsw.kakaobank.view.fragment.signup

import android.R.attr
import android.app.Activity
import android.content.ContentResolver
import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import kr.hs.dgsw.kakaobank.R
import kr.hs.dgsw.kakaobank.base.BaseFragment
import kr.hs.dgsw.kakaobank.databinding.FragmentSignupSelectImgBinding
import kr.hs.dgsw.kakaobank.view.activity.SignupActivity
import kr.hs.dgsw.kakaobank.viewmodel.signup.SignupSelectImgViewModel
import org.koin.android.ext.android.inject
import android.R.attr.bitmap
import java.io.*


class SignupSelectImgFragment :
    BaseFragment<FragmentSignupSelectImgBinding, SignupSelectImgViewModel>() {
    override val mViewModel: SignupSelectImgViewModel by inject()
    override val layoutRes: Int
        get() = R.layout.fragment_signup_select_img

    private val OPEN_GALLARY: Int = 1
    private var imageCheck = false;

    override fun observerViewModel() {
        with(mViewModel) {
            imageSelectBtn.observe(this@SignupSelectImgFragment, Observer {
                val intent = Intent(Intent.ACTION_GET_CONTENT)
                intent.setType("image/*")
                startActivityForResult(intent, OPEN_GALLARY)
            })

            nextBtn.observe(this@SignupSelectImgFragment, Observer {
                if (imageCheck) {
                    this@SignupSelectImgFragment.findNavController()
                        .navigate(R.id.action_signupSelectImgFramgent_to_signupPasswordFramgent)
                } else {
                    this@SignupSelectImgFragment.findNavController()
                        .navigate(R.id.action_signupSelectImgFramgent_to_askImageFragment)
                }
            })
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == OPEN_GALLARY) {
                var currentImageUri: Uri? = data?.data
                try {
                    currentImageUri.let {
                        if (Build.VERSION.SDK_INT < 28) {
                            val bitmap =
                                MediaStore.Images.Media.getBitmap(activity?.contentResolver, it)
                            mBinding.signupSProfileImage.setImageBitmap(bitmap)
                            if (currentImageUri != null) {
                                bitmapCovertFile(bitmap, getRealPathFromUri(currentImageUri))
                            }
                        } else {
                            val source =
                                ImageDecoder.createSource(activity?.contentResolver!!, it!!)
                            val bitmap = ImageDecoder.decodeBitmap(source)
                            mBinding.signupSProfileImage.setImageBitmap(bitmap)
                            if (currentImageUri != null) {
                                bitmapCovertFile(bitmap, getRealPathFromUri(currentImageUri))
                            }
                        }
                        imageCheck = true;
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        } else if (requestCode == Activity.RESULT_CANCELED) {
            Toast.makeText(requireContext(), "사진 선택 취소", Toast.LENGTH_SHORT).show()
        }
    }

    fun bitmapCovertFile(bitmap: Bitmap, filePath: String) {
        var file = File(filePath)

        var os: OutputStream? = null

        try {
            file.createNewFile()
            os = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, os)

            (activity as SignupActivity).request.file = file
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            try {
                os?.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun getRealPathFromUri(uri: Uri): String {
        var proj = MediaStore.Images.Media.DATA
        val cursor = requireContext().contentResolver.query(uri, arrayOf(proj), null, null, null)
        var idx = 0
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                idx = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
            }

            return cursor.getString(idx)
        }
        return ""
    }
}