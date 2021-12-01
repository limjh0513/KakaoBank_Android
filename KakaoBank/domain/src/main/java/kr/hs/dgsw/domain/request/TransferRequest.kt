package kr.hs.dgsw.domain.request

data class TransferRequest(
    var fromAccountNumber: String?,
    var toAccountNumber: String?,
    var toBank: String?,
    var toMoney: Int?,
) {
    constructor() : this(null, null, null, null)
}
