package com.exam.application.core.network.client

import com.exam.application.core.data.base.AppConfiguration
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

fun createHttpClient(
    appConfig: AppConfiguration,
    interceptor: Interceptor,
    loggingInterceptor: HttpLoggingInterceptor,
): OkHttpClient =
    OkHttpClient.Builder().apply {
        //Header
        addInterceptor(interceptor)
        // Logger
        addInterceptor(loggingInterceptor)
        // Timeout
        connectTimeout(appConfig.timeout, TimeUnit.MILLISECONDS)
        readTimeout(appConfig.timeout, TimeUnit.MILLISECONDS)
        writeTimeout(appConfig.timeout, TimeUnit.MILLISECONDS)
    }.build()