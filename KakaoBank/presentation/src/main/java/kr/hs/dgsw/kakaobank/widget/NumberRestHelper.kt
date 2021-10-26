package kr.hs.dgsw.kakaobank.widget

import java.text.DecimalFormat

fun getRestNumber(number: String): String{
    val decFormat = DecimalFormat("###,###")

    var restNumbr: String = decFormat.format(number)

    return restNumbr
}