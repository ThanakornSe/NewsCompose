package com.exam.application.domain.newsfeed.usecase

import com.exam.application.data.newsdata.model.NewsApiModel
import com.exam.application.data.newsdata.repository.NewsFeedRepository
import com.exam.application.domain.newsfeed.model.ArticleModel
import com.exam.application.domain.newsfeed.model.NewsModel
import com.exam.application.domain.newsfeed.model.SourceModel
import java.lang.Exception

class GetNewsFeedUseCase(private val repository: NewsFeedRepository) {

    suspend fun getNewsFeed(
        searchQuery: String,
        countryCode: String,
        pageNumber: Int
    ): NewsModel {

        val response: NewsApiModel = repository.getNewsFeed(
            searchQuery = searchQuery,
            countryCode = countryCode,
            pageNumber = pageNumber
        )

        val result = NewsModel(
            articleModels = response.articleApiModels?.map { article ->
                ArticleModel(
                    author = article.author,
                    content = article.content,
                    description = article.description,
                    publishedAt = article.publishedAt,
                    sourceModel = SourceModel(
                        id = article.sourceApiModel?.id,
                        name = article.sourceApiModel?.name
                    ),
                    title = article.title,
                    url = article.url,
                    urlToImage = article.urlToImage
                )
            },
            status = response.status,
            totalResults = response.totalResults
        )

        return result

    }
}