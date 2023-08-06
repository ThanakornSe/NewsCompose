package com.exam.application.core.network.di

import com.exam.application.core.data.di.coreDataModule
import com.exam.application.core.network.client.createHttpClient
import com.exam.application.core.network.client.createHttpHeaderInterceptor
import com.exam.application.core.network.client.createHttpLoggingInterceptor
import org.koin.dsl.module

val networkModule = module {
    includes(coreDataModule)
    single { createHttpLoggingInterceptor() }
    single { createHttpHeaderInterceptor(get()) }

    single {
        createHttpClient(
            appConfig = get(),
            interceptor = get(),
            loggingInterceptor = get()
        )
    }
}