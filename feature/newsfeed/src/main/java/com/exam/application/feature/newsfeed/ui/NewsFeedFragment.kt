package com.exam.application.feature.newsfeed.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.exam.application.core.resource.theme.AppTheme

@Composable
fun NewsFeedFragment(
    modifier: Modifier = Modifier,
    onClickToDetailScreen: (Int) -> Unit = {},
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        NewsFeedScreen(
            modifier = Modifier
                .padding(
                    horizontal = 16.dp
                ),
            onClickToDetailScreen = onClickToDetailScreen,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun NewsFeedFragmentPreview() {
    AppTheme {
        NewsFeedFragment()
    }
}