package com.example.kmm

import com.example.kmm.data.Dummy
import com.example.kmm.model.Product
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

object ProductsManager : CoroutineScope {
    private val job = SupervisorJob()
    override val coroutineContext: CoroutineContext
        get() = dispatcher() + job

    private val productsFlow = MutableStateFlow<List<Product>>(emptyList())
    fun getProductsFlow() = productsFlow.asStateFlow()

    private val searchEvent = Channel<String>(Channel.UNLIMITED)

    fun search(text: String) {
        launch {
            searchEvent.send(text)
        }
    }

    init {
        launch {
            searchEvent.receiveAsFlow()
                .debounce { 0L }
                .collectLatest { value ->
                    productsFlow.value = getProducts(value)
                }
        }
    }

    fun getProducts(text: String): List<Product> {
        return Dummy.getProducts().filter {
            val chars = text.toCharArray().map { it.toString() }
            with(it.productInfo) {
                chars.all { sku.contains(it) } || chars.all { name.contains(it) }
            }
        }
    }
}

