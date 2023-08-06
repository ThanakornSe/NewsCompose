package com.exam.application.data.newsdata.service

import com.exam.application.data.newsdata.model.NewsApiModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface GetNewsFeedApiServices {

    @GET("v2/top-headlines")
    suspend fun getSearchNews(
        @Query("q") searchQuery: String = "",
        @Query("country") countryCode: String = "us",
        @Query("page") pageNumber: Int = 1
    ): Response<NewsApiModel>

}