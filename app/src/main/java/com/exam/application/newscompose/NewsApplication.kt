package com.exam.application.newscompose

import android.app.Application
import com.exam.application.core.data.base.AppConfiguration
import com.exam.application.newscompose.di.newsAppModule
import org.koin.android.ext.android.get
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class NewsApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin()
        setupAppConfig()

    }

    private fun initKoin() {
        startKoin {
            androidContext(this@NewsApplication)
            androidLogger()
            modules(newsAppModule)
        }
    }

    private fun setupAppConfig() {
        val appConfig: AppConfiguration = get()
        appConfig.apply {
            isDebug = BuildConfig.DEBUG
            baseApiUrl = BuildConfig.BASE_URL
            buildVersion = BuildConfig.VERSION_NAME
        }
    }

    private fun setupTimber() {
        Timber.plant(Timber.DebugTree())
    }
}