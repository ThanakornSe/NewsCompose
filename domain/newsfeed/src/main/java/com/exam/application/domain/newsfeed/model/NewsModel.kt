package com.exam.application.domain.newsfeed.model


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class NewsModel(
    val articleModels: List<ArticleModel>? = null,
    val status: String? = null,
    val totalResults: Int? = null
) : Parcelable