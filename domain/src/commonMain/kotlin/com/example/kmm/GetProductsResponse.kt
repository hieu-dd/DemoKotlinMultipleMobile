package com.example.kmm

import kotlinx.serialization.Serializable

@Serializable
data class GetProductsResponse(
    val code: String = "",
    val message: String = "",
    val result: ProductResult? = null
) {
    @Serializable
    data class ProductResult(val products: List<Product> = emptyList())
}