package com.exam.application.core.network.client

import com.exam.application.core.data.Constant
import com.exam.application.core.data.base.AppConfiguration
import okhttp3.Interceptor
import okhttp3.Request

fun createHttpHeaderInterceptor(appConfig: AppConfiguration): Interceptor =
    Interceptor {
        it.proceed(
            it.request().newBuilder().headerSetup(appConfig)
        )
    }

fun Request.Builder.headerSetup(appConfig: AppConfiguration): Request {

    appConfig.apiKey?.let { value ->
        header(
            Constant.ServicePaths.X_API_KEY,
            value
        )
    }

    return build()
}