package com.exam.application.feature.newsfeed.viewmodel

import androidx.lifecycle.viewModelScope
import com.exam.application.core.base.BaseViewModel
import com.exam.application.domain.newsfeed.usecase.GetNewsFeedUseCase
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber


data class NewsFeedUiState(
    val articleList: List<ArticleCardUiState>? = null
)

data class ArticleCardUiState(
    val author: String? = null,
    val content: String? = null,
    val description: String? = null,
    val publishedAt: String? = null,
    val sourceName: String? = null,
    val title: String? = null,
    val url: String? = null,
    val urlToImage: String? = null
)

class NewsFeedViewModel(
    private val getNewsFeedUseCase: GetNewsFeedUseCase
): BaseViewModel<NewsFeedUiState>() {

    init {
        initNewsFeed()
    }
    private fun initNewsFeed() {
        viewModelScope.launch {
            try {
                setLoading(true)

                val result = getNewsFeedUseCase.getNewsFeed(
                    searchQuery = "",
                    countryCode = "us",
                    pageNumber = 1
                )

                setLoading(false)

                _uiState.update { currentState ->
                    currentState.copy(
                        mainUiState = NewsFeedUiState(
                            articleList = result.articleModels?.map {
                                ArticleCardUiState(
                                    author = it.author,
                                    content = it.content,
                                    description = it.description,
                                    publishedAt = it.publishedAt,
                                    sourceName = it.sourceModel?.name,
                                    title = it.title,
                                    url = it.url,
                                    urlToImage = it.urlToImage
                                )
                            }
                        )
                    )
                }
            } catch (e: Exception) {
                Timber.e(e)
                setLoading(false)
            }
        }
    }

}