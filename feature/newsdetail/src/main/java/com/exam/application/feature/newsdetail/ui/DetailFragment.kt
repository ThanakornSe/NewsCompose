package com.exam.application.feature.newsdetail.ui

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.exam.application.feature.newsdetail.ui.component.DetailScreen
import com.exam.application.core.resource.theme.AppTheme
import com.exam.application.core.util.BaseViewModelCommonCompose
import com.exam.application.feature.newsdetail.viewmodel.NewsDetailViewModel
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@ExperimentalMaterial3Api
@Composable
fun DetailFragment(
    modifier: Modifier = Modifier,
    id: String? = null,
    viewModel: NewsDetailViewModel = koinViewModel {
        parametersOf(
            id
        )
    },
    navController: NavController = rememberNavController()
) {

    BaseViewModelCommonCompose(viewModel = viewModel, navController)

    val uiState by viewModel.uiState.collectAsState()

    DetailScreen(uiState = uiState)
}

@Preview(showBackground = true)
@ExperimentalMaterial3Api
@Composable
fun DetailFragmentPreview() {
    AppTheme {
        DetailFragment()
    }
}