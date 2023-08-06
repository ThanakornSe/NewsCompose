package com.exam.application.core.data.route

import com.exam.application.core.data.route.RoutePath.DETAIL_ARG_NEWS_ID
import com.exam.application.core.data.route.RoutePath.DETAIL_SCREEN_FRAGMENT
import com.exam.application.core.data.route.RoutePath.DETAIL_SCREEN_NAV_GRAPH
import com.exam.application.core.data.route.RoutePath.NEWS_FEED_FRAGMENT
import com.exam.application.core.data.route.RoutePath.NEWS_FEED_NAV_GRAPH

sealed class Route(val route: String) {
    object NewsFeedNavGraph : Route(NEWS_FEED_NAV_GRAPH)
    object NewsFeedFragment : Route(NEWS_FEED_FRAGMENT)
    object DetailScreenNavGraph : Route(DETAIL_SCREEN_NAV_GRAPH)
    object DetailScreenFragment : Route("$DETAIL_SCREEN_FRAGMENT/{$DETAIL_ARG_NEWS_ID}") {
        fun createRoute(newsId: String) = "$DETAIL_SCREEN_FRAGMENT/$newsId"
    }

}