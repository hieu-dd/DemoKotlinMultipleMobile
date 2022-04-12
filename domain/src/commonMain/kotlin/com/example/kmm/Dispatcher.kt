package com.example.kmm

import kotlinx.coroutines.CoroutineDispatcher

internal expect fun backgroundDispatcher(): CoroutineDispatcher

internal expect fun dispatcher(): CoroutineDispatcher