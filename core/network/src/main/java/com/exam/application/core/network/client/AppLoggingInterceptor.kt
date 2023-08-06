package com.exam.application.core.network.client

import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber

fun createHttpLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor { message ->
    Timber.d(message)
}.apply {
    setLevel(HttpLoggingInterceptor.Level.BODY)
}