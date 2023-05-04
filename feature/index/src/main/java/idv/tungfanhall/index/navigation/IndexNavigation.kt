package idv.tungfanhall.index.navigation

import android.util.Log
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import idv.tungfanhall.common.model.common.isSelected
import idv.tungfanhall.common.model.common.route
import idv.tungfanhall.common.ui.BottomBarIcon
import idv.tungfanhall.index.screen.IndexScreen

@Composable
fun RowScope.IndexNavIcon(navController: NavController, destination: NavDestination?) {
    BottomBarIcon(
        label = "首頁",
        icon = Icons.Rounded.Home,
        onClick = { navController.navigateToIndexGraph() },
        selected = destination.isSelected(indexRoute)
    )
}

const val indexRoute = "index_route"

fun NavController.navigateToIndexGraph(navOptions: NavOptions? = null) {
    navigate(indexRoute, navOptions)
}

fun NavGraphBuilder.indexGraph() {
    composable(route = indexRoute) {
        IndexScreen()
    }
}