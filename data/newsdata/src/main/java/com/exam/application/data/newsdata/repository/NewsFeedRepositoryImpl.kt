package com.exam.application.data.newsdata.repository

import com.exam.application.data.newsdata.model.NewsApiModel
import com.exam.application.data.newsdata.service.GetNewsFeedApiServices
import java.lang.Exception

class NewsFeedRepositoryImpl(private val service: GetNewsFeedApiServices) : NewsFeedRepository {

    private var currentNewsFeed: NewsApiModel? = null
    override suspend fun getNewsFeed(
        searchQuery: String,
        countryCode: String,
        pageNumber: Int
    ): NewsApiModel {
        val response = service.getSearchNews(
            searchQuery = searchQuery,
            countryCode = countryCode,
            pageNumber = pageNumber
        )
        currentNewsFeed = response.body()?.takeIf { response.isSuccessful }
        return currentNewsFeed ?: throw Exception(response.message())

    }
}