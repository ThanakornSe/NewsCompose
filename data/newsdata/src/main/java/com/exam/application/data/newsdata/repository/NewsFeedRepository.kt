package com.exam.application.data.newsdata.repository

import com.exam.application.data.newsdata.model.NewsApiModel
import retrofit2.http.Query

interface NewsFeedRepository {
    suspend fun getNewsFeed(
        searchQuery: String = "",
        countryCode: String = "us",
        pageNumber: Int = 1
    ): NewsApiModel
}