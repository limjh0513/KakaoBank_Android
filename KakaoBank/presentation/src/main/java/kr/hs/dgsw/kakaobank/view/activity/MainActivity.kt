package kr.hs.dgsw.kakaobank.view.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
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

    override fun observerViewModel() {
        getAccount()

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
                val accountAdapter = AccountItemAdapter()
                accountAdapter.items = it
                accountAdapter.context = this@MainActivity

                mBinding.mainRecyclerview.adapter = accountAdapter
            })

            getErrorEvent.observe(this@MainActivity, Observer {
                Toast.makeText(this@MainActivity, "계좌 목록을 가져오는 중 문제가 발생했습니다.", Toast.LENGTH_SHORT)
                    .show()
            })
        }
    }

    private fun getAccount() {
        var token: String? = SharedPreferenceManager.getToken(this)

        if (token != null) {
            mViewModel.getAccountList("Bearer $token")
        } else {
            Toast.makeText(this, "토큰이 존재하지 않습니다. 다시 로그인해주세요", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}