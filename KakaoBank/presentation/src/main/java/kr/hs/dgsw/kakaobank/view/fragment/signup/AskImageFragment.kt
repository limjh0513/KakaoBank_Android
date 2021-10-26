package kr.hs.dgsw.kakaobank.view.fragment.signup

import android.content.Context
import android.database.Cursor
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import kr.hs.dgsw.kakaobank.R
import kr.hs.dgsw.kakaobank.base.BaseFragment
import kr.hs.dgsw.kakaobank.databinding.FragmentAskImageBinding
import kr.hs.dgsw.kakaobank.view.activity.SignupActivity
import kr.hs.dgsw.kakaobank.viewmodel.signup.AskImageViewModel
import org.koin.android.ext.android.inject
import java.io.BufferedOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream

class AskImageFragment : BaseFragment<FragmentAskImageBinding, AskImageViewModel>() {
    override val mViewModel: AskImageViewModel by inject()
    override val layoutRes: Int
        get() = R.layout.fragment_ask_image

    override fun observerViewModel() {
        with(mViewModel) {
            negativeBtn.observe(this@AskImageFragment, Observer {
                this@AskImageFragment.findNavController()
                    .navigate(R.id.action_askImageFragment_to_signupSelectImgFramgent)
            })

            positiveBtn.observe(this@AskImageFragment, Observer {
                (activity as SignupActivity).file = null
                this@AskImageFragment.findNavController()
                    .navigate(R.id.action_askImageFragment_to_signupPasswordFramgent)
            })
        }
    }
}