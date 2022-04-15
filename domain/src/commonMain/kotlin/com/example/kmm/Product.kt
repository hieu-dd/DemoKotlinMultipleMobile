package com.example.kmm

import kotlinx.serialization.Serializable

@Serializable
data class Product(
    val productInfo: ProductInfo = ProductInfo(),
) {
    @Serializable
    data class ProductInfo(
        val sku: String = "",
        val name: String = ""
    )
}