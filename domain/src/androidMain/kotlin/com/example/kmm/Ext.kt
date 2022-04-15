package com.example.kmm

import java.text.DecimalFormat
import java.util.*

actual object Extension {
    actual fun formatMoney(value: Double): String {
        val formatter = DecimalFormat.getCurrencyInstance(Locale("vi", "VN")) as DecimalFormat
        formatter.decimalFormatSymbols = formatter.decimalFormatSymbols.apply {
            currencySymbol = ""
        }
        return "${formatter.format(value + 0.0).trim()} đ"
    }
}
