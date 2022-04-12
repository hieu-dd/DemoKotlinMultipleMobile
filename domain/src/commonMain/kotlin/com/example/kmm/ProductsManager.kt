package com.example.kmm

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

    private val productsFlow = MutableStateFlow<List<Product>>(fake)
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
                .debounce {
                    1000L
                }.collectIndexed { index, value ->
                    productsFlow.value = fake.filter { it.sku.contains(value) }
                }
        }
    }
}

val fake = listOf<Product>(
    Product("1", 1, "1"),
    Product("2", 2, "2")
)
