package com.exam.application.feature.newsdetail.navgraph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.exam.application.core.data.route.Route
import com.exam.application.core.data.route.RoutePath.DETAIL_ARG_NEWS_ID
import com.exam.application.core.data.route.RoutePath.DETAIL_SCREEN_FRAGMENT
import com.exam.application.feature.newsdetail.ui.DetailFragment

fun NavGraphBuilder.newsDetailNavGraph(navController: NavController) {
    navigation(startDestination = DETAIL_SCREEN_FRAGMENT, route = Route.DetailScreenNavGraph.route) {
        composable(
            route = Route.DetailScreenFragment.route,
            arguments = listOf(
                navArgument(DETAIL_ARG_NEWS_ID) {
                    type = NavType.StringType
                }
            )
        ) { backstackEntry ->
            val newsId = backstackEntry.arguments?.getInt(DETAIL_ARG_NEWS_ID)
            requireNotNull(newsId) { "News id parameter wasn't found. Please make sure it's set!" }
            DetailFragment(id = newsId)
        }
    }
}