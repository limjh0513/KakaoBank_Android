package kr.hs.dgsw.domain.model

import java.io.Serializable

data class OtherAccount(
    val accountNumber : String,
    val bank: String,
    val money: Int,
    val nickname: String,
    var isSuccess: Boolean
): Serializable