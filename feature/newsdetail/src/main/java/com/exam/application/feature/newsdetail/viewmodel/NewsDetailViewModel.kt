package com.exam.application.feature.newsdetail.viewmodel


import androidx.lifecycle.viewModelScope
import com.exam.application.core.base.BaseViewModel
import com.exam.application.core.resource.ResourcesProvider
import com.exam.application.core.util.timeAgo
import com.exam.application.domain.newsfeed.usecase.GetNewsDetailUseCase
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber
import com.exam.application.resource.R

data class NewsDetailUiState(
    val toolBarTitle: String? = null,
    val author: String? = null,
    val content: String? = null,
    val description: String? = null,
    val publishedAt: String? = null,
    val sourceName: String? = null,
    val title: String? = null,
    val url: String? = null,
    val urlToImage: String? = null
)

class NewsDetailViewModel(
    private val newsId: String? = null,
    private val getNewsDetailUseCase: GetNewsDetailUseCase,
    private val resourcesProvider: ResourcesProvider
) : BaseViewModel<NewsDetailUiState>() {

    init {
        getArticleDetail()
    }

    private fun getArticleDetail() {

        viewModelScope.launch {
            try {
                setLoading(true)
                val result = getNewsDetailUseCase.getNewsDetail(newsId ?: "")
                setLoading(false)

                _uiState.update { currentState ->
                    currentState.copy(
                        mainUiState = NewsDetailUiState(
                            toolBarTitle = resourcesProvider.getString(R.string.news_detail_toolbar_title),
                            author = result.author,
                            content = result.content,
                            description = result.description,
                            publishedAt = result.publishedAt?.timeAgo(),
                            sourceName = result.sourceModel?.name,
                            title = result.title,
                            url = result.url,
                            urlToImage = result.urlToImage
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