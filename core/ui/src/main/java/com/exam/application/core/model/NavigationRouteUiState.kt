package com.exam.application.core.model

sealed class NavigationRouteUiState {
    data class NavigationToRouteUiState(val route: String): NavigationRouteUiState()

}
