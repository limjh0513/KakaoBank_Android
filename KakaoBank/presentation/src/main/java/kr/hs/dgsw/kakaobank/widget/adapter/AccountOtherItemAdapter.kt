package kr.hs.dgsw.kakaobank.widget.adapter

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import kr.hs.dgsw.domain.model.Account
import kr.hs.dgsw.kakaobank.R
import kr.hs.dgsw.kakaobank.databinding.AccountImportItemBinding
import kr.hs.dgsw.kakaobank.viewmodel.other.OtherSelectViewModel
import kr.hs.dgsw.kakaobank.widget.getRestNumber

class AccountOtherItemAdapter : RecyclerView.Adapter<AccountOtherItemAdapter.ViewHolder>() {
    lateinit var binding: AccountImportItemBinding
    lateinit var items: List<Account>
    lateinit var context: Context
    lateinit var mViewModel: OtherSelectViewModel

    var selectList: ArrayList<Account> = ArrayList()

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
            getBankground(account.kindOfBank)

            binding.itemImpBankName.text = account.kindOfBank

            binding.itemImpView.setOnClickListener {
                if (checkIsSelect(account)) {
                    selectList.add(account)
                    Log.e("asdfasdf", account.accountNumber.toString())
                    binding.itemImpView.background =
                        ContextCompat.getDrawable(context, R.drawable.other_show_select)
                } else {
                    selectList.remove(account)
                    getBankground(account.kindOfBank)
                }

                mViewModel.selectList.value = selectList.toList()
            }

        }
    }

    fun getBankground(bank: String){
        if (bank.equals("KBANK")) {
            binding.itemImpView.background =
                ContextCompat.getDrawable(context, R.drawable.other_show_kbank)
        } else if (bank.equals("TOSS")) {
            binding.itemImpView.background =
                ContextCompat.getDrawable(context, R.drawable.other_show_toss)
        } else if (bank.equals("DAEGU")) {
            binding.itemImpView.background =
                ContextCompat.getDrawable(context, R.drawable.other_show_deagu)
        } else if (bank.equals("MAAGU")) {
            binding.itemImpView.background =
                ContextCompat.getDrawable(context, R.drawable.other_show_maggu)
        } else {
            binding.itemImpView.background =
                ContextCompat.getDrawable(context, R.drawable.kakao_border_view)
        }
    }

    fun checkIsSelect(account: Account): Boolean {
        for (a in selectList) {
            if (a == account) {
                return false
            }
        }
        return true
    }
}