package com.exam.application.feature.newsdetail.ui

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.arudo.jetpackcompose.fragment.detail.screen.DetailScreen
import com.exam.application.core.resource.theme.AppTheme


@Composable
fun DetailFragment(
    modifier: Modifier = Modifier,
    id: Int = -1,
) {

    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        DetailScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun DetailFragmentPreview() {
    AppTheme {
        DetailFragment()
    }
}