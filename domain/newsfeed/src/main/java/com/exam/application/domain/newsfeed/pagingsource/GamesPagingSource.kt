package com.exam.application.domain.newsfeed.pagingsource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.exam.application.data.newsdata.repository.NewsFeedRepository
import com.exam.application.domain.newsfeed.model.ArticleModel
import com.exam.application.domain.newsfeed.model.NewsModel
import com.exam.application.domain.newsfeed.model.SourceModel

class NewsPagingSource(
    private val response: suspend (Int) -> NewsModel,
) : PagingSource<Int, ArticleModel>() {

    override fun getRefreshKey(state: PagingState<Int, ArticleModel>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ArticleModel> {
        return try {
            val nextPage = params.key ?: 1
            val articleList = response.invoke(nextPage)
            LoadResult.Page(
                data = articleList.articleModels ?: emptyList(),
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = if (articleList.articleModels?.isNotEmpty() == true) {
                    nextPage + 1
                } else {
                    null
                }
            )
        } catch (exception: Exception) {
            return LoadResult.Error(exception)
        }
    }
}