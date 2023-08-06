package com.exam.application.core.base

import android.content.Intent
import androidx.lifecycle.ViewModel
import com.exam.application.core.model.NavigationRouteUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

open class BaseViewModel<T> : ViewModel() {

    // Expose screen UI state
    protected val _uiState = MutableStateFlow(BaseUiState<T>())
    open val uiState: StateFlow<BaseUiState<T>> get() = _uiState.asStateFlow()

    fun navigationTo(route: String) {
        _uiState.update { currentState ->
            currentState.copy(
                navigation = NavigationRouteUiState.NavigationToRouteUiState(route = route)
            )
        }
    }

    fun clearNavigationUiState() {
        _uiState.update { currentState ->
            currentState.copy(
                navigation = null
            )
        }
    }

    fun setLoading(isLoading: Boolean) {
        _uiState.update { currentState ->
            currentState.copy(
                isLoading = isLoading
            )
        }
    }

    fun openIntent(intent: Intent) {
        _uiState.update { currentState ->
            currentState.copy(
                openIntent = intent
            )
        }
    }

    fun clearOpenIntent() {
        _uiState.update { currentState ->
            currentState.copy(
                openIntent = null
            )
        }
    }



    fun clearErrorMessage() {
        _uiState.update { currentState ->
            currentState.copy(
                errorMessage = null
            )
        }
    }
}