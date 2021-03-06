package kr.hs.dgsw.kakaobank.view.activity

import android.content.Intent
import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import kr.hs.dgsw.data.util.SharedPreferenceManager
import kr.hs.dgsw.kakaobank.R
import kr.hs.dgsw.kakaobank.base.BaseActivity
import kr.hs.dgsw.kakaobank.databinding.ActivityMainBinding
import kr.hs.dgsw.kakaobank.viewmodel.MainViewModel
import kr.hs.dgsw.kakaobank.widget.adapter.AccountItemAdapter
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override val mViewModel: MainViewModel by inject()
    override val layoutRes: Int
        get() = R.layout.activity_main

    override fun onRestart() {
        super.onRestart()
        getAccount()
    }

    override fun observerViewModel() {
        getInit()

        mBinding.mainRefresh.setOnRefreshListener {
            mBinding.mainRefresh.isRefreshing = false
            getAccount()
        }

        with(mViewModel) {
            openUpBtn.observe(this@MainActivity, Observer {
                val intent = Intent(this@MainActivity, OpenupActivity::class.java)
                startActivity(intent)
            })

            accountList.observe(this@MainActivity, Observer {
                if (it.size <= 0) {
                    mBinding.mainViewHint.visibility = View.VISIBLE
                } else {
                    mBinding.mainViewHint.visibility = View.INVISIBLE
                }

                val accountAdapter = AccountItemAdapter()
                accountAdapter.items = it
                accountAdapter.context = this@MainActivity

                mBinding.mainRecyclerview.adapter = accountAdapter
            })

            getErrorEvent.observe(this@MainActivity, Observer {
                Toast.makeText(this@MainActivity, "?????? ????????? ???????????? ??? ????????? ??????????????????.", Toast.LENGTH_SHORT)
                    .show()
            })

            otherAccountView.observe(this@MainActivity, Observer {
                val intent = Intent(this@MainActivity, OtherActivity::class.java)
                startActivity(intent)
            })

            getUserErrorEvent.observe(this@MainActivity, Observer {
                Toast.makeText(this@MainActivity, "?????? ????????? ???????????? ??? ????????? ??????????????????..", Toast.LENGTH_SHORT)
                    .show()
            })

            getUserData.observe(this@MainActivity, Observer {
                mBinding.mainTvName.text = it.name

                Log.e("dfadf", it.profileImg)

                Glide.with(this@MainActivity.applicationContext)
                    .load("http://${it.profileImg}")
                    .override(50, 50)
                    .error(R.drawable.default_profile)
                    .into(mBinding.imageProfile)
            })

            settingBtn.observe(this@MainActivity, Observer {
                val intent = Intent(this@MainActivity, SettingActivity::class.java)
                startActivity(intent)
            })
        }
    }

    private fun getInit() {
        var token: String? = SharedPreferenceManager.getToken(this)

        if (token != null) {
            mViewModel.getUser("Bearer $token")
            mViewModel.getAccountList("Bearer $token")
        } else {
            Toast.makeText(this, "????????? ???????????? ????????????. ?????? ?????????????????????", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    private fun getAccount() {
        var token: String? = SharedPreferenceManager.getToken(this)

        if (token != null) {
            mViewModel.getAccountList("Bearer $token")
        } else {
            Toast.makeText(this, "????????? ???????????? ????????????. ?????? ?????????????????????", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}