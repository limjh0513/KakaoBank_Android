package kr.hs.dgsw.domain.repository

import io.reactivex.Single
import kr.hs.dgsw.domain.model.Account

interface AccountRepository {
    fun getAccount(token: String): Single<List<Account>>
}