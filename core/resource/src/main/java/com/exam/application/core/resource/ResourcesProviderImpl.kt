package com.tisconet.mo5.core.resource

import android.content.Context
import android.content.pm.ApplicationInfo

class ResourcesProviderImpl(
    private val context: Context
): ResourcesProvider {
    override fun getString(id: Int): String {
        return context.getString(id)
    }

    override fun getPackageName(): String {
        return context.packageName
    }

    override fun getApplicationInfo(): ApplicationInfo {
        return context.applicationInfo
    }
}