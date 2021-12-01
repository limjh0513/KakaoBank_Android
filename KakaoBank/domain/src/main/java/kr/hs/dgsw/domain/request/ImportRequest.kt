package kr.hs.dgsw.domain.request

data class ImportRequest(
    val fromAccountNum: String,
    val money: Int,
    val toAccountNum: String,
)