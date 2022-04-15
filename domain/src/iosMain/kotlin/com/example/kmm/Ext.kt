package com.example.kmm

import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import platform.Foundation.NSNumber
import platform.Foundation.NSNumberFormatter

fun ProductsManager.observerProducts(
    onSuccess: (List<Product>) -> Unit
) = getProductsFlow().onEach {
    onSuccess(it)
}.launchIn(this)

actual object Extension {
    actual fun formatMoney(value: Double): String {
        val formatter = NSNumberFormatter()
        formatter.maximumFractionDigits = 2u
        formatter.minimumFractionDigits = 0u
        formatter.numberStyle = 1u //
        return "${formatter.stringFromNumber(NSNumber(value))} đ"
    }
}