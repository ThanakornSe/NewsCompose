package com.exam.application.feature.newsfeed.ui

import android.content.Intent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
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
    navController: NavController = rememberNavController()
) {

    val uiState by viewModel.uiState.collectAsState()

    BaseViewModelCommonCompose(viewModel = viewModel, navController)

    NewsFeedScreen(
        modifier = Modifier,
        uiState = uiState,
        onClickToDetailScreen = { viewModel.navigationTo(it) },
        onShareClick = {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, it)
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            viewModel.openIntent(shareIntent)
        }
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