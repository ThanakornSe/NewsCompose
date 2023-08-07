package com.exam.application.feature.newsfeed.navgraph

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.exam.application.core.data.route.Route
import com.exam.application.core.data.route.RoutePath.DETAIL_ARG_NEWS_ID
import com.exam.application.core.data.route.RoutePath.NEWS_FEED_FRAGMENT
import com.exam.application.core.util.decodeBase64
import com.exam.application.core.util.encodeBase64
import com.exam.application.domain.newsfeed.model.ArticleModel
import com.exam.application.feature.newsfeed.ui.DetailFragment
import com.exam.application.feature.newsfeed.ui.NewsFeedFragment
import com.exam.application.feature.newsfeed.viewmodel.ArticleCardUiState
import com.squareup.moshi.Moshi

@ExperimentalMaterial3Api
fun NavGraphBuilder.newsFeedNavGraph(navController: NavController) {


    navigation(startDestination = NEWS_FEED_FRAGMENT, route = Route.NewsFeedNavGraph.route) {
        composable(route = Route.NewsFeedFragment.route) {
            NewsFeedFragment(
                clickToRoute = { id ->
                    val moshi = Moshi.Builder().build()
                    val jsonAdapter = moshi.adapter(ArticleCardUiState::class.java).lenient()
                    val articleJson = jsonAdapter.toJson(id)
                    val articleBase64 = articleJson.encodeBase64()

                    navController.navigate(
                        Route.DetailScreenFragment.route.replace(
                            "{$DETAIL_ARG_NEWS_ID}",
                            articleBase64
                        )
                    )
                },
                navController = navController
            )
        }

        composable(
            route = Route.DetailScreenFragment.route,
            arguments = listOf(
                navArgument(DETAIL_ARG_NEWS_ID) {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val newsId = backStackEntry.arguments?.getString(DETAIL_ARG_NEWS_ID)
            val decodeBase64 = newsId?.decodeBase64()
            val moshi = Moshi.Builder().build()
            val jsonAdapter = moshi.adapter(ArticleCardUiState::class.java).lenient()
            val articleModel = jsonAdapter.fromJson(decodeBase64)


            DetailFragment(
                id = articleModel,
                navController = navController
            )
        }
    }
}