package com.exam.application.core.base

import android.content.Intent
import com.exam.application.core.model.NavigationRouteUiState

data class BaseUiState<T>(
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val navigation: NavigationRouteUiState? = null,
    val mainUiState: T? = null,
    val openIntent: Intent? = null,
)
