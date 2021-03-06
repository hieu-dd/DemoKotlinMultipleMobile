package com.example.kmm.model

import com.example.kmm.data.Dummy

data class Cart(
    var items: MutableList<CartItem> = mutableListOf()
) {
    fun getPrice(): Double = items.sumOf { item ->
        (Dummy.getProducts().find { it.productInfo.sku == item.sku }?.prices?.firstOrNull()?.sellPrice
            ?: 0.0) * item.quantity
    }

    fun getTotalItems(): Int = items.sumOf { it.quantity }
}

data class CartItem(
    val sku: String,
    val name: String,
    val image: String,
    var quantity: Int,
    var price: Double
)