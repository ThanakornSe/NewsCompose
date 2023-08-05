package com.exam.application.core.ui.view.compose

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.exam.application.core.resource.theme.AppTheme

@ExperimentalMaterial3Api
@Composable
fun NewsTopAppBarColors(
    containerColor: Color = MaterialTheme.colorScheme.background,
    navigationIconContentColor: Color = MaterialTheme.colorScheme.onBackground,
    titleContentColor: Color = MaterialTheme.colorScheme.onPrimary,
    actionIconContentColor: Color = MaterialTheme.colorScheme.onBackground,
): TopAppBarColors {
    return TopAppBarDefaults.centerAlignedTopAppBarColors(
        containerColor = containerColor,
        titleContentColor = titleContentColor,
        navigationIconContentColor = navigationIconContentColor,
        actionIconContentColor = actionIconContentColor
    )
}

@ExperimentalMaterial3Api
@Composable
fun NewsTopAppBar(
    title: String,
    modifier: Modifier = Modifier,
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    windowInsets: WindowInsets = TopAppBarDefaults.windowInsets,
    colors: TopAppBarColors = NewsTopAppBarColors(),
    scrollBehavior: TopAppBarScrollBehavior? = null
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.displayMedium,
                color = MaterialTheme.colorScheme.onPrimary,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                textAlign = TextAlign.Center
            )
        },
        modifier = modifier,
        navigationIcon = navigationIcon,
        actions = actions,
        windowInsets = windowInsets,
        colors = colors,
        scrollBehavior = scrollBehavior
    )
}


@ExperimentalMaterial3Api
@Preview
@Composable
fun DefaultNewsTopAppBarPreview() {
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