package kr.hs.dgsw.domain.request

data class OtherAccountRequest(
    val accountNumber: String,
    val bank: String,
    val money: Int,
    val nickname: String,
)