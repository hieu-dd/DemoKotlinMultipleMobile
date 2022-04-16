package com.example.kmm

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromJsonElement
import kotlin.coroutines.CoroutineContext

object ProductsManager : CoroutineScope {
    private val client = HttpClient() {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                prettyPrint = true
                isLenient = true
            })
        }
    }
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
        search("")
        launch {
            searchEvent.receiveAsFlow()
                .debounce { 0L }
                .collectLatest { value ->
                    productsFlow.value = getProducts(value)
                }
        }
    }

    fun getProducts(text: String): List<Product> {
        return Json { ignoreUnknownKeys = true }
            .decodeFromString<GetProductsResponse.ProductResult>(Dummy.productsJson).products.filter {
                val chars = text.toCharArray().map { it.toString() }
                with(it.productInfo) {
                    chars.all { sku.contains(it) } || chars.all { name.contains(it) }
                }
            }

    }
}

