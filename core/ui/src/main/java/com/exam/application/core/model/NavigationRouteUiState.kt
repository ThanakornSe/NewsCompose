package com.exam.application.core.model

sealed class NavigationRouteUiState {
    data class NavigationToRouteUiState(val route: String): NavigationRouteUiState()

    data class NavigationWithBackstackUiState(val route: String, val popupBackstack: Int): NavigationRouteUiState()
}
