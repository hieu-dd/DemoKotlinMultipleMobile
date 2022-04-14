package com.example.kmm

import kotlinx.coroutines.flow.onEach

fun ProductsManager.observerProducts(
    onSuccess: (List<Product>) -> Unit
) = getProductsFlow().onEach {
    onSuccess(it)
}