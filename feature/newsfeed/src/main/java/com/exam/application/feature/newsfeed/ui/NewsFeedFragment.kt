package com.exam.application.feature.newsfeed.ui

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.exam.application.core.resource.theme.AppTheme
import com.exam.application.core.util.BaseViewModelCommonCompose
import com.exam.application.feature.newsfeed.ui.component.NewsFeedScreen
import com.exam.application.feature.newsfeed.viewmodel.NewsFeedViewModel
import org.koin.androidx.compose.koinViewModel

@ExperimentalMaterial3Api
@Composable
fun NewsFeedFragment(
    modifier: Modifier = Modifier,
    viewModel: NewsFeedViewModel = koinViewModel(),
    onClickToDetailScreen: (String) -> Unit = {},
) {

    val uiState by viewModel.uiState.collectAsState()

    BaseViewModelCommonCompose(viewModel = viewModel)

    NewsFeedScreen(
        modifier = Modifier,
        uiState = uiState,
        onClickToDetailScreen = onClickToDetailScreen,
    )
}

@Preview(showBackground = true)
@ExperimentalMaterial3Api
@Composable
fun NewsFeedFragmentPreview() {
    AppTheme {
        NewsFeedFragment()
    }
}