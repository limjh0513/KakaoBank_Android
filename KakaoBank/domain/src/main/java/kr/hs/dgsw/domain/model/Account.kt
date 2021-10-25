package kr.hs.dgsw.domain.model

data class Account(
    val accountNumber: String,
    val idx: Int,
    val kindOfBank: String,
    val money: Int,
    val nickname: String
)
