package idv.tungfanhall.index.navigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import idv.tungfanhall.common.ui.BottomBarIcon
import idv.tungfanhall.index.screen.IndexScreen

@Composable
fun RowScope.IndexNavIcon() {
    BottomBarIcon(label = "首頁", icon = Icons.Rounded.Home)
}

private const val indexGraphRoutePattern = "index_graph"
private const val indexRoute = "index_route"

fun NavController.navigateToIndexGraph(navOptions: NavOptions? = null) {
    navigate(indexGraphRoutePattern, navOptions)
}

fun NavGraphBuilder.indexGraph() {
    navigation(
        route = indexGraphRoutePattern,
        startDestination = indexRoute
    ) {
        composable(route = indexRoute) {
            IndexScreen()
        }
    }
}