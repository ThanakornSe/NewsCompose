package com.exam.application.data.newsdata.model


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class NewsApiModel(
    @Json(name = "articles")
    val articleApiModels: List<ArticleApiModel>? = null,
    @Json(name = "status")
    val status: String? = null,
    @Json(name = "totalResults")
    val totalResults: Int? = null
) : Parcelable