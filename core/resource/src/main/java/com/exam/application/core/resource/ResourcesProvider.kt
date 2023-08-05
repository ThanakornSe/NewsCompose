package com.tisconet.mo5.core.resource

import android.content.pm.ApplicationInfo
import androidx.annotation.StringRes

interface ResourcesProvider {
    fun getString(@StringRes id: Int): String

    fun getPackageName(): String

    fun getApplicationInfo(): ApplicationInfo
}