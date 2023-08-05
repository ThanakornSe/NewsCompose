package com.exam.application.feature.newsfeed.navgraph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.exam.application.core.data.route.Route
import com.exam.application.core.data.route.RoutePath.NEWS_FEED_FRAGMENT
import com.exam.application.feature.newsfeed.ui.NewsFeedFragment

fun NavGraphBuilder.newsFeedNavGraph(navController: NavController) {
    navigation(startDestination = NEWS_FEED_FRAGMENT, route = Route.NewsFeedNavGraph.route) {
        composable(route = Route.NewsFeedFragment.route) {
            NewsFeedFragment(
                onClickToDetailScreen = { newsId ->
                    navController.navigate(
                        Route.DetailScreenFragment.createRoute(newsId)
                    )
                }
            )
        }
    }
}