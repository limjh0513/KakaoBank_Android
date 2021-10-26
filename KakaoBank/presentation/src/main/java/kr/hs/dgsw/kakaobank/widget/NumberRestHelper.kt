package kr.hs.dgsw.kakaobank.widget

import java.text.DecimalFormat

fun getRestNumber(number: String): String{
    val decFormat = DecimalFormat("###,###")

    var restNumber: String = decFormat.format(Integer.parseInt(number))

    return restNumber
}