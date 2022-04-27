package com.example.kmm

import com.example.kmm.model.Cart
import com.example.kmm.model.CartItem
import com.example.kmm.model.Product
import com.example.kmm.utils.copy
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.coroutines.CoroutineContext

object CartManager : CoroutineScope {
    private val job = SupervisorJob()
    override val coroutineContext: CoroutineContext
        get() = dispatcher() + job


    private val cartFlow = MutableStateFlow(Cart())
    fun getCartFlow(): StateFlow<Cart> = cartFlow.asStateFlow()

    fun addItem(product: Product) {
        cartFlow.apply {
            val items = value.items.copy()
            items.find { it.sku == product.productInfo.sku }?.apply {
                quantity++
            } ?: items.add(CartItem(product.productInfo.sku, 1))
            value = Cart(items)
        }
    }
}