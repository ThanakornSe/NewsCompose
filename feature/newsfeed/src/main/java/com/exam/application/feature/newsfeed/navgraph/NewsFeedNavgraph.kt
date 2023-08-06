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
import com.exam.application.core.data.route.RoutePath.DETAIL_ARG_PAGE
import com.exam.application.core.data.route.RoutePath.DETAIL_ARG_WORD
import com.exam.application.core.data.route.RoutePath.NEWS_FEED_FRAGMENT
import com.exam.application.feature.newsfeed.ui.DetailFragment
import com.exam.application.feature.newsfeed.ui.NewsFeedFragment

@ExperimentalMaterial3Api
fun NavGraphBuilder.newsFeedNavGraph(navController: NavController) {


    navigation(startDestination = NEWS_FEED_FRAGMENT, route = Route.NewsFeedNavGraph.route) {
        composable(route = Route.NewsFeedFragment.route) {
            NewsFeedFragment(
                clickToRoute = { id, page ->
                    navController.navigate(Route.DetailScreenFragment.createRoute(id, page))
                },
                navController = navController
            )
        }

        composable(
            route = Route.DetailScreenFragment.route,
            arguments = listOf(
                navArgument(DETAIL_ARG_NEWS_ID) {
                    type = NavType.StringType
                },
                navArgument(DETAIL_ARG_PAGE) {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val newsId = backStackEntry.arguments?.getString(DETAIL_ARG_NEWS_ID)
            val page = backStackEntry.arguments?.getInt(DETAIL_ARG_PAGE)

            DetailFragment(
                id = newsId,
                page = page ?: 1,
                navController = navController
            )
        }
    }
}