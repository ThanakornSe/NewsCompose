package com.exam.application.feature.newsfeed.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.exam.application.core.resource.theme.AppTheme

@Composable
fun NewsFeedScreen(
    modifier: Modifier = Modifier,
    onClickToDetailScreen: (Int) -> Unit = {},
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {

        Button(
            modifier = Modifier.align(Alignment.Center),
            onClick = { onClickToDetailScreen.invoke(1) })
        {

            Text(text = "Go to Detail Fragment", color = Color.White)

        }

    }

}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    AppTheme {
        NewsFeedScreen()
    }
}