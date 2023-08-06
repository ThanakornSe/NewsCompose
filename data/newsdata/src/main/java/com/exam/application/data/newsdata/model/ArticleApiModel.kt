package com.exam.application.data.newsdata.model


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class ArticleApiModel(
    @Json(name = "author")
    val author: String? = null,
    @Json(name = "content")
    val content: String? = null,
    @Json(name = "description")
    val description: String? = null,
    @Json(name = "publishedAt")
    val publishedAt: String? = null,
    @Json(name = "source")
    val sourceApiModel: SourceApiModel? = null,
    @Json(name = "title")
    val title: String? = null,
    @Json(name = "url")
    val url: String? = null,
    @Json(name = "urlToImage")
    val urlToImage: String? = null
):Parcelable