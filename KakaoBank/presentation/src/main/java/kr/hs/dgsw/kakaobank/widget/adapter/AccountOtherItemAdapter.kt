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
import kr.hs.dgsw.kakaobank.databinding.AccountOtherItemBinding
import kr.hs.dgsw.kakaobank.viewmodel.other.OtherSelectViewModel
import kr.hs.dgsw.kakaobank.widget.getRestNumber

class AccountOtherItemAdapter : RecyclerView.Adapter<AccountOtherItemAdapter.ViewHolder>() {
    lateinit var binding: AccountOtherItemBinding
    lateinit var items: List<Account>
    lateinit var context: Context
    lateinit var mViewModel: OtherSelectViewModel

    var selectList: ArrayList<Account> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.account_other_item,
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

    inner class ViewHolder(mBinding: AccountOtherItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(account: Account) {
            binding.itemOtherMoney.text = getRestNumber(account.money.toString())
            binding.itemOtherTvNick.text = account.nickname
            binding.itemOtherTvNumber.text = account.accountNumber
            getBankground(account.kindOfBank)

            binding.itemOtherBankName.text = account.kindOfBank

            binding.itemOtherImportCheckBox.setOnCheckedChangeListener { buttonView, isChecked ->
                Log.e("asdfasdf", account.accountNumber.toString())
                if (isChecked) {
                    selectList.add(account)
                } else {
                    selectList.remove(account)
                }

                mViewModel.selectList.value = selectList.toList()
            }
        }
    }

    fun getBankground(bank: String) {
        if (bank.equals("KBANK")) {
            binding.itemOtherView.background =
                ContextCompat.getDrawable(context, R.drawable.other_show_kbank)
        } else if (bank.equals("TOSS")) {
            binding.itemOtherView.background =
                ContextCompat.getDrawable(context, R.drawable.other_show_toss)
        } else if (bank.equals("DAEGU")) {
            binding.itemOtherView.background =
                ContextCompat.getDrawable(context, R.drawable.other_show_deagu)
        } else if (bank.equals("MAAGU")) {
            binding.itemOtherView.background =
                ContextCompat.getDrawable(context, R.drawable.other_show_maggu)
        } else {
            binding.itemOtherView.background =
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