package kr.hs.dgsw.data.network

data class Response<T>(
    val status: Int,
    val message: String,
    val data: T
)