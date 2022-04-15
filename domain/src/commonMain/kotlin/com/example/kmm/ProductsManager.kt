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
import kotlinx.serialization.json.Json
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

    suspend fun getProducts(text: String): List<Product> {
        return try {
            val response: GetProductsResponse = client.post("https://discovery.dev.tekoapis.net/api/v1/search") {
                contentType(ContentType.Application.Json)
                setBody(mapOf(Pair("location", "00"), Pair("terminalCode", "CP01"), Pair("query", text)))
            }.body()
            response.result?.products.orEmpty()
        } catch (e: Throwable) {
            emptyList()
        }
    }
}

