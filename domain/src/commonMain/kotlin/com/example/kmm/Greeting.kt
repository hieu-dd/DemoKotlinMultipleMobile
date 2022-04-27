package com.example.kmm

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

class Greeting {
    private val client = HttpClient()

    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }


    suspend fun getHtml(): String {
        val response = client.get("https://ktor.io/docs")
        return "${greeting()} ${response.bodyAsText()}"
    }
}

expect class Platform() {
    val platform: String
}