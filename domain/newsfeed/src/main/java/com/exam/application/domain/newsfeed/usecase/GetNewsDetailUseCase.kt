package com.exam.application.domain.newsfeed.usecase

import com.exam.application.data.newsdata.repository.NewsFeedRepository
import com.exam.application.domain.newsfeed.model.ArticleModel
import com.exam.application.domain.newsfeed.model.SourceModel

class GetNewsDetailUseCase(private val repository: NewsFeedRepository) {
    suspend fun getNewsDetail(newsId: String, page: Int): ArticleModel {

        val article = repository.getNewsFeed(
            pageNumber = page
        ).articleApiModels?.firstOrNull { it.title == newsId }


        return ArticleModel(
            author = article?.author,
            content = article?.content,
            description = article?.description,
            publishedAt = article?.publishedAt,
            sourceModel = SourceModel(
                id = article?.sourceApiModel?.id,
                name = article?.sourceApiModel?.name
            ),
            title = article?.title,
            url = article?.url,
            urlToImage = article?.urlToImage
        )

    }
}