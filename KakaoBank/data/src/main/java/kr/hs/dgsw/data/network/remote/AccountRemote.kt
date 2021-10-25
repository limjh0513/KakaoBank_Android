package kr.hs.dgsw.data.network.remote

import io.reactivex.Single
import kr.hs.dgsw.data.base.BaseRemote
import kr.hs.dgsw.data.network.response.AccountData
import kr.hs.dgsw.data.network.service.AccountService
import kr.hs.dgsw.domain.model.Account

class AccountRemote(override val service: AccountService): BaseRemote<AccountService>() {
    fun getAccountList(token: String): Single<List<Account>> =
        service.getAccountList(token).map(getResponseData()).map(AccountData::accounts)
}