package com.exam.application.core.resource

import android.content.pm.ApplicationInfo
import androidx.annotation.StringRes

interface ResourcesProvider {
    fun getString(@StringRes id: Int): String

}