package com.exam.application.domain.newsfeed.model


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize


@Parcelize
@JsonClass(generateAdapter = true)
data class SourceModel(
    val id: String? = null,
    val name: String? = null
) : Parcelable