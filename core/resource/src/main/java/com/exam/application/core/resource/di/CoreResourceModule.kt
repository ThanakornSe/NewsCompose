package com.exam.application.core.resource.di

import com.exam.application.core.resource.ResourcesProvider
import com.exam.application.core.resource.ResourcesProviderImpl
import org.koin.dsl.module

val coreResourceModule = module {
    single<ResourcesProvider> { ResourcesProviderImpl(get()) }
}