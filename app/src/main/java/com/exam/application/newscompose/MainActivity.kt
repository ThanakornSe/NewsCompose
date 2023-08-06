package com.exam.application.newscompose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.exam.application.core.resource.theme.AppTheme
import com.exam.application.core.base.BaseComponentActivity
import com.exam.application.core.data.route.Route
import com.exam.application.feature.newsdetail.navgraph.newsDetailNavGraph
import com.exam.application.feature.newsfeed.navgraph.newsFeedNavGraph

@ExperimentalMaterial3Api
class MainActivity : BaseComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NewsComposeAppScreen()
                }
            }
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun NewsComposeAppScreen() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Route.NewsFeedNavGraph.route,
    ) {
        newsFeedNavGraph(navController)

        newsDetailNavGraph(navController)
    }
}

@Preview(showBackground = true)
@ExperimentalMaterial3Api
@Composable
fun GreetingPreview() {
    AppTheme {
        NewsComposeAppScreen()
    }
}