package kr.hs.dgsw.kakaobank.widget.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import kr.hs.dgsw.domain.model.Account
import kr.hs.dgsw.kakaobank.R
import kr.hs.dgsw.kakaobank.databinding.AccountItemBinding
import kr.hs.dgsw.kakaobank.widget.getRestNumber

class AccountItemAdapter : RecyclerView.Adapter<AccountItemAdapter.ViewHolder>() {

    lateinit var binding: AccountItemBinding
    lateinit var items: List<Account>
    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.account_item,
            parent,
            false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(context, items[position], position)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(binding: AccountItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(context: Context, account: Account, position: Int) {
            binding.itemTvNick.text = account.nickname
            binding.itemTvNumber.text = account.accountNumber
            binding.itemMoney.text = getRestNumber(account.money.toString())
            binding.itemBringBtn.setOnClickListener {

            }
            binding.itemSendBtn.setOnClickListener {

            }
            when (position % 5) {
                0 -> binding.itemView.background =
                    ContextCompat.getDrawable(context, R.drawable.border_item1)
                1 -> binding.itemView.background =
                    ContextCompat.getDrawable(context, R.drawable.border_item2)
                2 -> binding.itemView.background =
                    ContextCompat.getDrawable(context, R.drawable.border_item3)
                3 -> binding.itemView.background =
                    ContextCompat.getDrawable(context, R.drawable.border_item4)
                4 -> binding.itemView.background =
                    ContextCompat.getDrawable(context, R.drawable.border_item5)
            }
        }
    }
}