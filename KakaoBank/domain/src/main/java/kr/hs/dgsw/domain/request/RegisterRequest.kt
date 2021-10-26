package kr.hs.dgsw.domain.request

import java.io.File

data class RegisterRequest(
    var id: String?,
    var name: String?,
    var nickName: String?,
    var password: String?,
    var phoneNumber: String?,
    var residentRegistrationNumber: String?,
    var simpleNumber: Int?,
) {
    constructor(): this(null, null,null, null, null, null, null)
}
