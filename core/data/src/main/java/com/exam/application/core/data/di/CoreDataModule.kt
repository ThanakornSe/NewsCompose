package com.exam.application.core.data.di

import android.webkit.CookieManager
import com.exam.application.core.data.AppConfig
import com.exam.application.core.data.base.AppConfiguration
import org.koin.dsl.module

val coreDataModule = module {
    single<AppConfiguration> { AppConfig }
}