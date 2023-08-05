package com.exam.application.core.data

import com.exam.application.core.data.base.AppConfiguration

object AppConfig : AppConfiguration {
    override var isDebug: Boolean = false
    override var baseApiUrl: String? = null
    override var buildVersion: String? = null
}