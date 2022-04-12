package com.example.kmm

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

internal actual fun backgroundDispatcher(): CoroutineDispatcher = Dispatchers.IO

internal actual fun dispatcher(): CoroutineDispatcher = Dispatchers.Main.immediate