package com.exam.application.core.data.base

interface AppConfiguration {
    var isDebug: Boolean
    var baseApiUrl: String?
    var buildVersion: String?
}