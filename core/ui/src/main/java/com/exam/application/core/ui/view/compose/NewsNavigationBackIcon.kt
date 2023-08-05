package com.exam.application.core.ui.view.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.exam.application.core.resource.theme.AppTheme
import com.exam.application.resource.R

@Composable
fun NewsNavigationBackIcon(
    icon: @Composable () -> Unit = {
        Icon(
            painter = painterResource(id = R.drawable.ic_arrow_back_left),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onTertiary
        )
    },
    onClick: () -> Unit
) {
    IconButton(onClick = onClick) {
        icon.invoke()
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun DefaultNewsNavigationBackIconPreview() {
    AppTheme {
        Scaffold(
            topBar = {
                NewsTopAppBar(
                    title = "Title",
                    navigationIcon = {
                        NewsNavigationBackIcon {

                        }
                    }
                )
            }
        ) { contentPadding ->
            // Screen content
            Box(
                modifier = Modifier
                    .padding(contentPadding)
                    .fillMaxWidth()
                    .fillMaxHeight(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Hello, World",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    }
}