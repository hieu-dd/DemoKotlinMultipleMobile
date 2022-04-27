package com.example.kmm.model

import com.example.kmm.data.Dummy

data class Cart(
    var items: MutableList<CartItem> = mutableListOf()
) {
    fun getPrice(): Double = items.sumOf { item ->
        Dummy.getProducts().find { it.productInfo.sku == item.sku }?.prices?.firstOrNull()?.sellPrice ?: 0.0
    }

    fun getTotalItems(): Int = items.sumOf { it.quantity }
}

data class CartItem(
    val sku: String,
    var quantity: Int
)