package com.exam.application.domain.newsfeed.usecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.exam.application.data.newsdata.model.NewsApiModel
import com.exam.application.data.newsdata.repository.NewsFeedRepository
import com.exam.application.domain.newsfeed.model.ArticleModel
import com.exam.application.domain.newsfeed.model.NewsModel
import com.exam.application.domain.newsfeed.model.SourceModel
import com.exam.application.domain.newsfeed.pagingsource.NewsPagingSource
import kotlinx.coroutines.flow.Flow
import java.lang.Exception

class GetNewsFeedUseCase(private val repository: NewsFeedRepository) {

    suspend fun getNewsFeed(
        searchQuery: String = "",
        countryCode: String? = null
    ): Flow<PagingData<ArticleModel>> = Pager(
        config = PagingConfig(
            pageSize = 20,
            enablePlaceholders = true
        ),
        pagingSourceFactory = {
            NewsPagingSource(
                response = { pageNext ->
                    val response: NewsApiModel = repository.getNewsFeed(
                        searchQuery = searchQuery,
                        countryCode = countryCode ?: "us",
                        pageNumber = pageNext
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
                    return@NewsPagingSource result
                }
            )
        }
    ).flow
}