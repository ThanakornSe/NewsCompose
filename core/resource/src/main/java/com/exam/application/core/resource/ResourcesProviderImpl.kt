package com.exam.application.core.resource

import android.content.Context
import com.exam.application.core.resource.ResourcesProvider

class ResourcesProviderImpl(
    private val context: Context
): ResourcesProvider {
    override fun getString(id: Int): String {
        return context.getString(id)
    }
}