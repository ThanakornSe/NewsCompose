package com.exam.application.domain.newsfeed.di

import com.exam.application.data.newsdata.di.newsDataModule
import com.exam.application.domain.newsfeed.usecase.GetNewsDetailUseCase
import com.exam.application.domain.newsfeed.usecase.GetNewsFeedUseCase
import org.koin.dsl.module

val newsFeedDomainModule = module {
    includes(newsDataModule)
    single { GetNewsFeedUseCase(get()) }
    single { GetNewsDetailUseCase(get()) }
}