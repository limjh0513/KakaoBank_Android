package kr.hs.dgsw.domain.request

data class RegisterRequest(
    val id: String,
    val name: String,
    val nickName: String,
    val password: String,
    val phoneNumber: String,
    val residentRegistrationNumber: String
)
