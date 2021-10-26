package kr.hs.dgsw.domain.model

data class Account(
    val idx: Int,
    val accountNumber: String,
    val nickname: String,
    val money: Int,
    val kindOfBank: String,
)
