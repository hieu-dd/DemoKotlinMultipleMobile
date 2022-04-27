package com.example.kmm


expect class LocalData(context: KContext) {
    fun setBoolean(key: String, value: Boolean)

    fun getBoolean(key: String): Boolean
}