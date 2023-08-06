package com.exam.application.core.util


import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.exam.application.core.base.BaseViewModel
import com.exam.application.core.model.NavigationRouteUiState

@Composable
fun <T> BaseViewModelCommonCompose(
    viewModel: BaseViewModel<T>,
    navController: NavController = rememberNavController(),
) {
    val uiState by viewModel.uiState.collectAsState()

    uiState.openIntent?.let {
        LocalContext.current.startActivity(it)
        viewModel.clearOpenIntent()
    }

    uiState.navigation?.let { navigation ->
        when (navigation) {
            is NavigationRouteUiState.NavigationToRouteUiState -> {
                navController.navigate(route = navigation.route)
                viewModel.clearNavigationUiState()
            }

            is NavigationRouteUiState.NavigationWithBackstackUiState -> {
                var countdown = navigation.popupBackstack
                while (countdown-- > 0) {
                    if (!navController.popBackStack()) break
                }
                navController.navigate(route = navigation.route)
                viewModel.clearNavigationUiState()
            }
        }
    }

}