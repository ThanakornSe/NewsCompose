package com.exam.application.feature.newsfeed.di

import com.exam.application.core.data.di.coreDataModule
import com.exam.application.core.resource.di.coreResourceModule
import com.exam.application.data.newsdata.di.newsDataModule
import com.exam.application.domain.newsfeed.di.newsFeedDomainModule
import com.exam.application.feature.newsfeed.viewmodel.NewsDetailViewModel
import com.exam.application.feature.newsfeed.viewmodel.NewsFeedViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val newsFeedFeatureModule = module {
    includes(coreResourceModule, newsDataModule, newsFeedDomainModule)
    viewModel { NewsFeedViewModel(get(), get()) }
    viewModel { params -> NewsDetailViewModel(params[0], get()) }
}