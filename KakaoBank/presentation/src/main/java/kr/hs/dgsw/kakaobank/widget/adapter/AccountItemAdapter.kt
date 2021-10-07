package kr.hs.dgsw.kakaobank.widget.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import kr.hs.dgsw.kakaobank.R
import kr.hs.dgsw.kakaobank.databinding.AccountItemBinding

class AccountItemAdapter: RecyclerView.Adapter<AccountItemAdapter.ViewHolder>() {

    lateinit var binding: AccountItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.account_item, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    inner class ViewHolder(binding: AccountItemBinding): RecyclerView.ViewHolder(binding.root){

    }
}