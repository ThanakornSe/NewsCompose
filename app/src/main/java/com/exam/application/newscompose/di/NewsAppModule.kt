package com.exam.application.newscompose.di

import com.exam.application.core.data.di.coreDataModule
import com.exam.application.feature.newsfeed.di.newsFeedFeatureModule
import org.koin.dsl.module

val newsAppModule = module {
    includes(
        coreDataModule,
        newsFeedFeatureModule
    )
}