package com.exam.application.feature.newsdetail.navgraph

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.exam.application.core.data.route.Route
import com.exam.application.core.data.route.RoutePath.DETAIL_ARG_NEWS_ID
import com.exam.application.core.data.route.RoutePath.DETAIL_SCREEN_FRAGMENT
import com.exam.application.domain.newsfeed.model.ArticleModel
import com.exam.application.feature.newsdetail.ui.DetailFragment

@ExperimentalMaterial3Api
fun NavGraphBuilder.newsDetailNavGraph(navController: NavController) {
    navigation(
        startDestination = DETAIL_SCREEN_FRAGMENT,
        route = Route.DetailScreenNavGraph.route
    ) {
        composable(
            route = Route.DetailScreenFragment.route
        ) { backstackEntry ->
            val result = navController.previousBackStackEntry?.savedStateHandle?.get<ArticleModel>(DETAIL_ARG_NEWS_ID)
            DetailFragment(
                id = newsId,
                navController = navController
            )
        }
    }
}