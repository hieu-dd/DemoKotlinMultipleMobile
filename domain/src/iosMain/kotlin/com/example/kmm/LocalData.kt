package com.example.kmm

import platform.Foundation.NSUserDefaults

actual class LocalData actual constructor(val context: KContext) {
    actual fun getBoolean(key: String): Boolean {
        return NSUserDefaults.standardUserDefaults.boolForKey(key)
    }

    actual fun setBoolean(key: String, value: Boolean) {
        NSUserDefaults.standardUserDefaults.setBool(value, key)
    }
}