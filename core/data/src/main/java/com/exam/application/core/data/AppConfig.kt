package com.exam.application.core.data

import com.exam.application.core.data.base.AppConfiguration

object AppConfig : AppConfiguration {
    override var isDebug: Boolean = false
    override var baseApiUrl: String? = null
    override var buildVersion: String? = null
    override var apiKey: String? = null
    override var timeout: Long = 5 * 60 * 1000
}