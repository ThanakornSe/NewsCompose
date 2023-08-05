package com.exam.application.core.data

object Constant {

    object ServicePaths {
        private const val UNAUTH_PREFIX_PATH = "unauth"
        private const val AUTH_PREFIX_PATH = "unauth/verify"

        const val REFRESH_TOKEN = "$UNAUTH_PREFIX_PATH/refresh-access-token"

    }

}