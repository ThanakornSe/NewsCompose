package com.exam.application.feature.newsfeed.di

import com.exam.application.data.newsdata.di.newsDataModule
import com.exam.application.domain.newsfeed.di.newsFeedDomainModule
import com.exam.application.feature.newsfeed.viewmodel.NewsFeedViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val newsFeedFeatureModule = module {
    includes(newsDataModule, newsFeedDomainModule)
    viewModel { NewsFeedViewModel(get()) }
}