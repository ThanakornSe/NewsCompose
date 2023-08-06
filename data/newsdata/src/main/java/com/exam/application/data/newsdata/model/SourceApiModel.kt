package com.exam.application.data.newsdata.model


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize


@Parcelize
@JsonClass(generateAdapter = true)
data class SourceApiModel(
    @Json(name = "id")
    val id: String? = null,
    @Json(name = "name")
    val name: String? = null
) : Parcelable