package kr.hs.dgsw.domain.request

data class AccountRequest(
    var accountType: String = "BASIC",
    var nickname: String?,
    var password: String?,
) {
    constructor(): this("BASIC", null, null)
}