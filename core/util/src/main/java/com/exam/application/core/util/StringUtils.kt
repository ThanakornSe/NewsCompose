package com.exam.application.core.util

import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

@OptIn(ExperimentalEncodingApi::class)
fun String.encodeBase64(): String = Base64.UrlSafe.encode(this.toByteArray())

@OptIn(ExperimentalEncodingApi::class)
fun String.decodeBase64(): String = String(Base64.UrlSafe.decode(this))