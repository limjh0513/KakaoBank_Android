package kr.hs.dgsw.kakaobank.widget.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import kr.hs.dgsw.domain.model.Account
import kr.hs.dgsw.kakaobank.R
import kr.hs.dgsw.kakaobank.databinding.AccountImportItemBinding
import kr.hs.dgsw.kakaobank.widget.getRestNumber

class AccountImportItemAdapter : RecyclerView.Adapter<AccountImportItemAdapter.ViewHolder>() {
    lateinit var binding: AccountImportItemBinding
    lateinit var items: List<Account>
    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.account_import_item,
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

    inner class ViewHolder(binding: AccountImportItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(context: Context, account: Account, position: Int) {
            binding.itemImpMoney.text = getRestNumber(account.money.toString())
            binding.itemImpTvNick.text = account.nickname
            binding.itemImpTvNumber.text = account.accountNumber

            binding.itemImpView.setOnClickListener {

            }

            when (position % 5) {
                0 -> binding.itemImpView.background =
                    ContextCompat.getDrawable(context, R.drawable.border_item1)
                1 -> binding.itemImpView.background =
                    ContextCompat.getDrawable(context, R.drawable.border_item2)
                2 -> binding.itemImpView.background =
                    ContextCompat.getDrawable(context, R.drawable.border_item3)
                3 -> binding.itemImpView.background =
                    ContextCompat.getDrawable(context, R.drawable.border_item4)
                4 -> binding.itemImpView.background =
                    ContextCompat.getDrawable(context, R.drawable.border_item5)
            }
        }
    }
}