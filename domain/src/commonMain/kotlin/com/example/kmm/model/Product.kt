package com.example.kmm.model

import kotlinx.serialization.Serializable

@Serializable
data class Product(
    val productInfo: ProductInfo = ProductInfo(),
    val prices: List<Price> = listOf()
) {
    @Serializable
    data class ProductInfo(
        val sku: String = "",
        val name: String = "",
        val imageUrl: String = "",
    )

    @Serializable
    data class Price(
        val sellPrice: Double
    )
}