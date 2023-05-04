package idv.tungfanhall.search.navigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import idv.tungfanhall.common.ui.BottomBarIcon
import idv.tungfanhall.search.screen.SearchScreen

@Composable
fun RowScope.SearchNavIcon(navController: NavController) {
    BottomBarIcon(label = "搜尋", icon = Icons.Rounded.Search, onClick = { navController.navigateToSearchGraph() })
}

const val searchRoute = "search_route"

fun NavController.navigateToSearchGraph(navOptions: NavOptions? = null) {
    navigate(searchRoute, navOptions)
}

fun NavGraphBuilder.searchGraph() {
    composable(route = searchRoute) {
        SearchScreen()
    }
}