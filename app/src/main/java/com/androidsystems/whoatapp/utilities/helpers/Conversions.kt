package com.androidsystems.whoatapp.utilities.helpers

import java.text.DecimalFormat

class Conversions {

    fun convertToDecimalFormat(str: String): String {
        val decimalFormat = DecimalFormat("#,####,###")
        return decimalFormat.format(str.toInt())
    }
}