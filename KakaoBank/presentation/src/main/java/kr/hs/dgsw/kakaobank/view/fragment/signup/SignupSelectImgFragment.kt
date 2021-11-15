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
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
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
            if (requestCode == OPEN_GALLARY && data != null) {
                var currentImageUri: Uri = data?.data!!
                if (Build.VERSION.SDK_INT < 28) {
                    val bitmap =
                        MediaStore.Images.Media.getBitmap(activity?.contentResolver,
                            currentImageUri)
                    mBinding.signupSProfileImage.setImageBitmap(bitmap)
                    (activity as SignupActivity).profileImage = bitmap
                } else {
                    val source =
                        ImageDecoder.createSource(activity?.contentResolver!!, currentImageUri)
                    val bitmap = ImageDecoder.decodeBitmap(source)
                    mBinding.signupSProfileImage.setImageBitmap(bitmap)
                    (activity as SignupActivity).profileImage = bitmap
                }

                val path = createCopyAndReturnRealPath(currentImageUri)

                if (path != null) {
                    val file = File(path)

                    val fileBody = RequestBody.create("image/jpeg".toMediaTypeOrNull
                        (), file)

                    (activity as SignupActivity).file = MultipartBody.Part.createFormData("file",
                        "${file.name}.jpeg",
                        fileBody)
                    imageCheck = true
                } else {
                    (activity as SignupActivity).file = null
                }
            }
        } else if (requestCode == Activity.RESULT_CANCELED) {
            Toast.makeText(requireContext(), "사진 선택 취소", Toast.LENGTH_SHORT).show()
        }
    }

    fun createCopyAndReturnRealPath(uri: Uri): String? {
        val context = requireContext()
        val contentResolver = context.contentResolver ?: return null

        // Create file path inside app's data dir
        val filePath = (context.applicationInfo.dataDir + File.separator
                + System.currentTimeMillis())
        val file = File(filePath)
        try {
            val inputStream = contentResolver.openInputStream(uri) ?: return null
            val outputStream: OutputStream = FileOutputStream(file)
            val buf = ByteArray(1024)
            var len: Int
            while (inputStream.read(buf).also { len = it } > 0) outputStream.write(buf, 0, len)
            outputStream.close()
            inputStream.close()
            return file.getAbsolutePath()
        } catch (e: Exception) {
            return null
        }
        return null
    }

}