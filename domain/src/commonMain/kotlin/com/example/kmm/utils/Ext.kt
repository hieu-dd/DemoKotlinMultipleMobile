package com.example.kmm.utils

import com.example.kmm.model.CartItem

expect object Extension {
    fun formatMoney(value: Double): String
}

fun List<CartItem>.copy() = map { it.copy() }.toMutableList()
