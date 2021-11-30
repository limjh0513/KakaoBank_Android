package kr.hs.dgsw.domain.request

data class TransferRequest(
    val fromAccountNumber: String,
    val toAccountNumber: String,
    val toBank: String,
    val toMoney: Int,
)
