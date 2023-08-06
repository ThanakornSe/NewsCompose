package com.exam.application.feature.newsfeed.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.exam.application.core.base.BaseUiState
import com.exam.application.core.resource.theme.AppTheme
import com.exam.application.core.ui.view.compose.NewsNavigationBackIcon
import com.exam.application.core.ui.view.compose.NewsScaffold
import com.exam.application.core.ui.view.compose.NewsTopAppBar
import com.exam.application.core.ui.view.compose.NewsTopAppBarColors
import com.exam.application.feature.newsfeed.viewmodel.NewsFeedUiState
import com.exam.application.resource.R

@ExperimentalMaterial3Api
@Composable
fun NewsFeedScreen(
    modifier: Modifier = Modifier,
    uiState: BaseUiState<NewsFeedUiState>,
    onClickToDetailScreen: (String) -> Unit = {},
) {

    val focusManager = LocalFocusManager.current

    NewsScaffold(
        modifier = modifier
            .fillMaxSize().pointerInput(Unit) {
                detectTapGestures(onTap = {
                    focusManager.clearFocus()
                })
            },
        topBar = {
            NewsTopAppBar(
                title = "News",
                colors = NewsTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
//                navigationIcon = {
//                    onBackClick?.let {
//                        NewsNavigationBackIcon {
//                            onBackClick()
//                        }
//                    }
//                }
            )
        },
        containerColor = MaterialTheme.colorScheme.surface

    ) { contentPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
                .background(MaterialTheme.colorScheme.background)
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                value = "",
                onValueChange = {

                },
                label = {
                    Text(
                        text = "Search",
                        color = MaterialTheme.colorScheme.onSecondary,
                        style = MaterialTheme.typography.labelMedium
                    )
                },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_search),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onSecondary
                    )
                }
            )

            Spacer(modifier = Modifier.height(8.dp))

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                uiState.mainUiState?.articleList?.let { articleList ->
                    items(articleList) { data ->
                        NewsFeedContentCard(
                            title = data.title,
                            author = data.author,
                            desc = data.description,
                            sourceName = data.sourceName,
                            thumbNailImage = data.urlToImage,
                            timeAgo = data.publishedAt,
                            url = data.url,
                            seeDetailActionClick = {
                                onClickToDetailScreen.invoke(it)
                            },
                            onShareClick = {}
                        )
                    }
                }
            }
        }

    }


}

@Preview(showBackground = true)
@ExperimentalMaterial3Api
@Composable
fun HomeScreenPreview() {
    AppTheme {
        NewsFeedScreen(uiState = BaseUiState())
    }
}