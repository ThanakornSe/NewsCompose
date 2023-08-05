package com.arudo.jetpackcompose.fragment.detail.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.exam.application.core.resource.theme.AppTheme

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Magenta)
    ) {
        Button(
            modifier = Modifier.align(Alignment.Center),
            onClick = { /*TODO*/ }
        ) {

        }

    }

}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    AppTheme {
        DetailScreen()
    }
}