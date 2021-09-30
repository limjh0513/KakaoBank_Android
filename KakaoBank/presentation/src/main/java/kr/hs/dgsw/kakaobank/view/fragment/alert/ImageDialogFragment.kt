package kr.hs.dgsw.kakaobank.view.fragment.alert

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kr.hs.dgsw.kakaobank.R
import kr.hs.dgsw.kakaobank.databinding.FragmentImageDialogBinding
import kr.hs.dgsw.kakaobank.view.activity.WelcomeActivity
import kr.hs.dgsw.kakaobank.viewmodel.signup.ImageAlertViewModel

class ImageDialogFragment : DialogFragment() {
    lateinit var mBinding: FragmentImageDialogBinding
    lateinit var mViewModel: ImageAlertViewModel

    fun getInstance(): ImageDialogFragment {
        return ImageDialogFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        mBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_image_dialog, container, false)
        mViewModel = ViewModelProvider(this).get(ImageAlertViewModel::class.java)

        mBinding.lifecycleOwner = this
        mBinding.vm = mViewModel

        return mBinding.root
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        val activity = activity
        if (activity is DialogInterface.OnDismissListener) {
            (activity as DialogInterface.OnDismissListener).onDismiss(dialog)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
    }

    private fun observeViewModel() {
        with(mViewModel){
            negativeBtn.observe(this@ImageDialogFragment, Observer {
                dismiss()
            })

            positiveBtn.observe(this@ImageDialogFragment, Observer {
                this@ImageDialogFragment.findNavController().navigate(R.id.action_imageDialogFragment_to_signupPasswordFramgent)
                dismiss()
            })
        }
    }


}