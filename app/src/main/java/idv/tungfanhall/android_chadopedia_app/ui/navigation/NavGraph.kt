package idv.tungfanhall.android_chadopedia_app.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import idv.tungfanhall.android_chadopedia_app.ui.feature.detail.DetailScreen
import idv.tungfanhall.android_chadopedia_app.ui.feature.setting.SettingScreen
import idv.tungfanhall.android_chadopedia_app.ui.feature.doc.DocScreen

@Composable
fun NavGraph(modifier: Modifier = Modifier, navController: NavHostController) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = "home"
    ) {
        navigation(route = "home", startDestination = HomeNavRouter.Doc.path) {
            addDocScreen(navController, this)
            addSettingScreen(navController, this)
        }
        addPediaScreen(navController, this)
    }

}

private fun addPediaScreen(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(route = PediaNavRouter.Detail.path) {
        DetailScreen(navController = navController)
    }
}

private fun addDocScreen(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(route = HomeNavRouter.Doc.path) {
        DocScreen(navController)
    }
}

private fun addSettingScreen(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(route = HomeNavRouter.Setting.path) {
        SettingScreen()
    }
}