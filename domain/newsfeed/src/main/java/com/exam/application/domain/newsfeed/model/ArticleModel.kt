package com.exam.application.domain.newsfeed.model


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class ArticleModel(
    val author: String? = null,
    val content: String? = null,
    val description: String? = null,
    val publishedAt: String? = null,
    val sourceModel: SourceModel? = null,
    val title: String? = null,
    val url: String? = null,
    val urlToImage: String? = null
):Parcelable