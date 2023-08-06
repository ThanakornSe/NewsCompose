package com.exam.application.data.newsdata.di

import com.exam.application.core.data.di.coreDataModule
import com.exam.application.core.network.di.retrofitModule
import com.exam.application.data.newsdata.repository.NewsFeedRepository
import com.exam.application.data.newsdata.repository.NewsFeedRepositoryImpl
import com.exam.application.data.newsdata.service.GetNewsFeedApiServices
import org.koin.dsl.module
import retrofit2.Retrofit

val newsDataModule = module {
    includes(retrofitModule, coreDataModule)
    factory { createNewsFeedApiService(get()) }
    single<NewsFeedRepository> { NewsFeedRepositoryImpl(get()) }
}

private fun createNewsFeedApiService(retrofit: Retrofit): GetNewsFeedApiServices =
    retrofit.create(GetNewsFeedApiServices::class.java)