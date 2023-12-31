package com.exam.application.feature.newsfeed.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import com.exam.application.core.base.BaseUiState
import com.exam.application.core.resource.theme.AppTheme
import com.exam.application.core.ui.view.compose.NewsScaffold
import com.exam.application.core.ui.view.compose.NewsTopAppBar
import com.exam.application.core.ui.view.compose.NewsTopAppBarColors
import com.exam.application.feature.newsfeed.viewmodel.ArticleCardUiState
import com.exam.application.feature.newsfeed.viewmodel.NewsFeedUiState
import com.exam.application.resource.R

@ExperimentalMaterial3Api
@Composable
fun NewsFeedScreen(
    modifier: Modifier = Modifier,
    uiState: BaseUiState<NewsFeedUiState>,
    onShareClick: (String) -> Unit = {},
    onClickToDetailScreen: (ArticleCardUiState) -> Unit = { _ -> },
) {

    val focusManager = LocalFocusManager.current
    val newsItem = uiState.mainUiState?.articleList?.collectAsLazyPagingItems()

    var searchQuery by rememberSaveable { mutableStateOf("") }

    NewsScaffold(
        modifier = modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    focusManager.clearFocus()
                })
            },
        topBar = {
            NewsTopAppBar(
                title = uiState.mainUiState?.toolbarTitleFeed ?: "",
                colors = NewsTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
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
                value = searchQuery,
                onValueChange = {
                    searchQuery = it
                    uiState.mainUiState?.searchNews?.invoke(searchQuery)
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

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                newsItem?.let { articleList ->
                    items(articleList.itemCount) { index ->
                        articleList[index]?.let { data ->
                            NewsFeedContentCard(
                                title = data.title,
                                author = data.author,
                                desc = data.description ?: data.content,
                                sourceName = data.sourceName,
                                thumbNailImage = data.urlToImage,
                                timeAgo = data.publishedAt,
                                url = data.url,
                                page = data.page,
                                seeDetailActionClick = {
                                    onClickToDetailScreen.invoke(data)
                                },
                                onShareClick = {
                                    onShareClick(it)
                                }
                            )
                        }
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