package com.exam.application.feature.newsfeed.viewmodel

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.exam.application.core.base.BaseViewModel
import com.exam.application.core.resource.ResourcesProvider
import com.exam.application.core.util.timeAgo
import com.exam.application.domain.newsfeed.usecase.GetNewsFeedUseCase
import com.exam.application.resource.R
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber


data class NewsFeedUiState(
    val articleList: Flow<PagingData<ArticleCardUiState>>? = null,
    val searchNews: (String) -> Unit = {},
    val toolbarTitleFeed: String? = null
)

data class ArticleCardUiState(
    val author: String? = null,
    val content: String? = null,
    val description: String? = null,
    val publishedAt: String? = null,
    val sourceName: String? = null,
    val title: String? = null,
    val url: String? = null,
    val urlToImage: String? = null,
    val page: Int? = null
)

class NewsFeedViewModel(
    private val getNewsFeedUseCase: GetNewsFeedUseCase,
    private val resourcesProvider: ResourcesProvider
) : BaseViewModel<NewsFeedUiState>() {

    init {
        getNewsFeed()
    }

    private fun getNewsFeed(searchText: String = "") {
        viewModelScope.launch {
            try {

                val result: Flow<PagingData<ArticleCardUiState>> =
                    getNewsFeedUseCase.getNewsFeed(searchQuery = searchText).map { data ->
                        data.map {
                            ArticleCardUiState(
                                author = it.author,
                                content = it.content,
                                description = it.description,
                                publishedAt = it.publishedAt?.timeAgo(),
                                sourceName = it.sourceModel?.name,
                                title = it.title,
                                url = it.url,
                                urlToImage = it.urlToImage,
                                page = it.page
                            )
                        }
                    }.cachedIn(viewModelScope)


                _uiState.update { currentState ->
                    currentState.copy(
                        mainUiState = NewsFeedUiState(
                            articleList = result,
                            searchNews = { getNewsFeed(it) },
                            toolbarTitleFeed = resourcesProvider.getString(R.string.news_feed_toolbar_title)
                        )
                    )
                }
            } catch (e: Exception) {
                Timber.e(e)
            }
        }
    }


}