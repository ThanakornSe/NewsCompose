package com.exam.application.newscompose.di

import com.exam.application.core.data.di.coreDataModule
import org.koin.dsl.module

val newsAppModule = module {
    includes(
        coreDataModule
    )
}