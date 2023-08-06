package com.exam.application.core.network.di

import com.exam.application.core.data.base.AppConfiguration
import com.exam.application.core.data.di.coreDataModule
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val retrofitModule = module {
    includes(coreDataModule)
    includes(networkModule)
    single { createRetrofit(get(), get(), get()) }
    factory { provideMoshiBuilder() }
}

private fun createRetrofit(appConfiguration: AppConfiguration, moshi: Moshi, httpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(appConfiguration.baseApiUrl ?: "")
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .client(httpClient)
        .build()
}

fun provideMoshiBuilder(): Moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
