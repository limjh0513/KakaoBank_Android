package kr.hs.dgsw.data.network.response


import com.google.gson.annotations.SerializedName
import kr.hs.dgsw.domain.model.Account

data class AccountData(
    val accounts: List<Account>
)