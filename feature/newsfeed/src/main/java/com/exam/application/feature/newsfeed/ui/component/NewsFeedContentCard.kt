package com.exam.application.feature.newsfeed.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import com.exam.application.core.data.route.Route
import com.exam.application.core.resource.theme.AppTheme
import com.exam.application.resource.R


@ExperimentalMaterial3Api
@Composable
fun NewsFeedContentCard(
    modifier: Modifier = Modifier,
    title: String? = null,
    author: String? = null,
    desc: String? = null,
    sourceName: String? = null,
    thumbNailImage: String? = null,
    timeAgo: String? = null,
    url:String? = null,
    seeDetailActionClick: (String) -> Unit = {},
    onShareClick: (String) -> Unit = {}
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface)
            .clip(RoundedCornerShape(8.dp))
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                shape = RoundedCornerShape(8.dp)
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        //Source Name
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            text = sourceName ?: "",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.onPrimary,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        author?.let {
            //Author
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                text = it,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onPrimary,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        //Content Image
        SubcomposeAsyncImage(model = thumbNailImage, contentDescription = null) {
            when (painter.state) {
                is AsyncImagePainter.State.Loading -> {
                    CircularProgressIndicator()
                }

                is AsyncImagePainter.State.Error -> {
                    AsyncImage(
                        modifier = Modifier
                            .aspectRatio(ratio = 16 / 9f)
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .clickable {
                                title?.let {
                                    seeDetailActionClick(Route.DetailScreenFragment.createRoute(it))
                                }
                            },
                        model = null,
                        contentScale = ContentScale.FillHeight,
                        placeholder = painterResource(id = R.drawable.ic_placeholder_image),
                        contentDescription = null,
                    )
                }

                else -> {
                    AsyncImage(
                        modifier = Modifier
                            .aspectRatio(ratio = 16 / 9f)
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .clickable {
                                title?.let {
                                    seeDetailActionClick(it)
                                }
                            },
                        model = thumbNailImage,
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
                .padding(horizontal = 16.dp)
                .clickable {
                    title?.let {
                        seeDetailActionClick(Route.DetailScreenFragment.createRoute(it))
                    }
                },
            text = title ?: "",
            color = MaterialTheme.colorScheme.onTertiary,
            style = MaterialTheme.typography.headlineLarge,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = desc ?: "",
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .clickable {
                    title?.let {
                        seeDetailActionClick(it)
                    }
                },
            style = MaterialTheme.typography.bodyMedium,
            overflow = TextOverflow.Ellipsis,
            maxLines = 3
        )

        Spacer(modifier = Modifier.height(16.dp))

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.onSecondaryContainer
        )

        //Action Bottom bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

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
                    text = timeAgo ?: "",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSecondary
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Row(
                modifier = Modifier
                    .clip(CircleShape)
                    .clickable {
                        url?.let {
                            onShareClick(it)
                        }
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_share),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSecondary
                )

                Spacer(modifier = Modifier.width(4.dp))

                Text(
                    text = stringResource(R.string.news_feed_share_button),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSecondary
                )
            }
        }
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun DefaultFeedContentCardPreview() {
    AppTheme {
        NewsFeedContentCard(
            title = "SEC Reportedly Asked Coinbase to Halt All Trading—Except for Bitcoin",
            desc = "Coinbase’s CEO Brian Armstrong reportedly told the Financial Times that the U.S. Securities & Exchange Commission asked him to halt trading in the exchange with all currencies except bitcoin. According to Armstrong, the suggestion came just before the SEC sue…",
            sourceName = "Gizmodo.com",
            author = "Kevin Hurler",
            thumbNailImage = "https://i.kinja-img.com/gawker-media/image/upload/c_fill,f_auto,fl_progressive,g_center,h_675,pg_1,q_80,w_1200/76f95899df261776c441932b344183f1.jpg",
            timeAgo = "4 นาที",
        )
    }
}
