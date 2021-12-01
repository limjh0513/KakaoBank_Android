package kr.hs.dgsw.domain.request

data class ImportRequest(
    var fromAccountNum: String?,
    var money: Int?,
    var toAccountNum: String?,
) {
    constructor(): this(null, null, null)
}