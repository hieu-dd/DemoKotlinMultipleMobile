package com.example.kmm

import android.content.Context.MODE_PRIVATE

actual class LocalData actual constructor(val context: KContext) {
    val sharedPreferences = context.getSharedPreferences("KMM", MODE_PRIVATE)

    actual fun getBoolean(key: String): Boolean {
        return sharedPreferences.getBoolean(key, false)
    }

    actual fun setBoolean(key: String, value: Boolean) {
        sharedPreferences.edit().putBoolean(key, value).commit()
    }
}