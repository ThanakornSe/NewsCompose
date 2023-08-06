package com.exam.application.feature.newsfeed.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.rememberAsyncImagePainter
import com.exam.application.core.base.BaseUiState
import com.exam.application.core.resource.theme.AppTheme
import com.exam.application.core.ui.view.compose.NewsNavigationBackIcon
import com.exam.application.core.ui.view.compose.NewsScaffold
import com.exam.application.core.ui.view.compose.NewsTopAppBar
import com.exam.application.core.ui.view.compose.NewsTopAppBarColors
import com.exam.application.feature.newsfeed.viewmodel.ArticleCardUiState
import com.exam.application.resource.R

@ExperimentalMaterial3Api
@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    uiState: BaseUiState<ArticleCardUiState>,
    onBackClick: () -> Unit = {}
) {

    NewsScaffold(
        modifier = modifier
            .fillMaxSize(),
        topBar = {
            NewsTopAppBar(
                title = stringResource(id = R.string.news_detail_toolbar_title),
                colors = NewsTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                navigationIcon = {
                    NewsNavigationBackIcon {
                        onBackClick()
                    }
                }
            )
        },
        containerColor = MaterialTheme.colorScheme.surface

    ) { contentPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
                .background(MaterialTheme.colorScheme.background),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            //Content Image
            SubcomposeAsyncImage(
                model = uiState.mainUiState?.urlToImage,
                contentDescription = null
            ) {
                when (painter.state) {
                    is AsyncImagePainter.State.Loading -> {
                        CircularProgressIndicator()
                    }

                    is AsyncImagePainter.State.Error -> {
                        AsyncImage(
                            modifier = Modifier
                                .aspectRatio(ratio = 16 / 9f)
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(8.dp)),
                            model = null,
                            contentScale = ContentScale.FillBounds,
                            placeholder = painterResource(id = R.drawable.ic_placeholder_image),
                            contentDescription = null,
                        )
                    }

                    else -> {
                        AsyncImage(
                            modifier = Modifier
                                .aspectRatio(ratio = 16 / 9f)
                                .fillMaxWidth(),
                            model = uiState.mainUiState?.urlToImage,
                            contentScale = ContentScale.FillHeight,
                            placeholder = painterResource(id = R.drawable.ic_placeholder_image),
                            contentDescription = null,
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            //Title
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                text = uiState.mainUiState?.title ?: "",
                color = MaterialTheme.colorScheme.onTertiary,
                style = MaterialTheme.typography.headlineLarge,
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = uiState.mainUiState?.content ?: uiState.mainUiState?.description ?: "",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier
                    .clip(CircleShape),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_clock),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSecondary
                )

                Spacer(modifier = Modifier.width(4.dp))

                Text(
                    text = uiState.mainUiState?.publishedAt ?: "",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSecondary
                )
            }

        }

    }
}

@Preview(showBackground = true)
@ExperimentalMaterial3Api
@Composable
fun DetailScreenPreview() {
    AppTheme {
        DetailScreen(
            uiState = BaseUiState(
                mainUiState = ArticleCardUiState(

                )
            )
        )
    }
}