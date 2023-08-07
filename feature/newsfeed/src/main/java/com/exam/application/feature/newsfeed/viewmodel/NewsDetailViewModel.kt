package com.exam.application.feature.newsfeed.viewmodel

import androidx.lifecycle.viewModelScope
import com.exam.application.core.base.BaseViewModel
import com.exam.application.core.util.timeAgo
import com.exam.application.domain.newsfeed.usecase.GetNewsDetailUseCase
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber

class NewsDetailViewModel(
    private val articleId: ArticleCardUiState? = null,
    private val getNewsDetailUseCase: GetNewsDetailUseCase
) : BaseViewModel<ArticleCardUiState>() {

    init {
        initScreen()
    }

    private fun initScreen() {
        viewModelScope.launch {
            try {

                val result = articleId

                _uiState.update { currentState ->
                    currentState.copy(
                        mainUiState = ArticleCardUiState(
                            author = result?.author,
                            content = result?.content,
                            description = result?.description,
                            publishedAt = result?.publishedAt,
                            sourceName = result?.sourceName,
                            title = result?.title,
                            url = result?.url,
                            urlToImage = result?.urlToImage
                        )
                    )
                }

            } catch (e: Exception) {
                Timber.d(e.message)
            }
        }
    }
}