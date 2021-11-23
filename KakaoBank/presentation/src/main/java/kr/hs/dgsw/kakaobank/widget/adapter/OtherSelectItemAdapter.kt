package kr.hs.dgsw.kakaobank.widget.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import kr.hs.dgsw.domain.model.OtherAccount
import kr.hs.dgsw.kakaobank.R
import kr.hs.dgsw.kakaobank.databinding.OtherSelectItemBinding

class OtherSelectItemAdapter : RecyclerView.Adapter<OtherSelectItemAdapter.ViewHolder>() {
    lateinit var binding: OtherSelectItemBinding
    lateinit var items: List<OtherAccount>
    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.other_select_item,
            parent,
            false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(mBinding: OtherSelectItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(otherAccount: OtherAccount) {
            binding.otherIBank.text = otherAccount.bank
            binding.otherIAccountNumber.text = otherAccount.accountNumber
            binding.otherIAccountName.text = otherAccount.nickname
            getBankground(otherAccount.bank)
            if(otherAccount.isSuccess){
                binding.imageIsSuccess.setImageResource(R.drawable.is_checked)
            } else {
                binding.imageIsSuccess.setImageResource(R.drawable.is_cancel)
            }
        }
    }

    fun getBankground(bank: String) {
        if (bank.equals("KBANK")) {
            binding.otherSelectView.background =
                ContextCompat.getDrawable(context, R.drawable.other_show_kbank)
        } else if (bank.equals("TOSS")) {
            binding.otherSelectView.background =
                ContextCompat.getDrawable(context, R.drawable.other_show_toss)
        } else if (bank.equals("DAEGU")) {
            binding.otherSelectView.background =
                ContextCompat.getDrawable(context, R.drawable.other_show_deagu)
        } else if (bank.equals("MAAGU")) {
            binding.otherSelectView.background =
                ContextCompat.getDrawable(context, R.drawable.other_show_maggu)
        } else {
            binding.otherSelectView.background =
                ContextCompat.getDrawable(context, R.drawable.kakao_border_view)
        }
    }
}