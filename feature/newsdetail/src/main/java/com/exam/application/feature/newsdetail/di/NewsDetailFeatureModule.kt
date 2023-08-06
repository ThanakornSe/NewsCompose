package com.exam.application.feature.newsdetail.di

import com.exam.application.core.data.di.coreDataModule
import com.exam.application.core.resource.di.coreResourceModule
import com.exam.application.data.newsdata.di.newsDataModule
import com.exam.application.domain.newsfeed.di.newsFeedDomainModule
import com.exam.application.feature.newsdetail.viewmodel.NewsDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val newsDetailFeatureModule = module {
    includes(coreResourceModule, newsDataModule, newsFeedDomainModule)
    viewModel { params -> NewsDetailViewModel(params[0], get(), get()) }
}