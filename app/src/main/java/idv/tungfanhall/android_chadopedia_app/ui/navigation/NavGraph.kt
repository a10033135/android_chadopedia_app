package idv.tungfanhall.android_chadopedia_app.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import idv.tungfanhall.android_chadopedia_app.ui.feature.detail.DetailScreen
import idv.tungfanhall.android_chadopedia_app.ui.feature.main.DocViewModel
import idv.tungfanhall.android_chadopedia_app.ui.feature.setting.SettingScreen
import idv.tungfanhall.android_chadopedia_app.ui.feature.pedia.PediaScreen
import idv.tungfanhall.android_chadopedia_app.ui.feature.search.SearchScreen

@Composable
fun NavGraph(modifier: Modifier = Modifier, navController: NavHostController, docVM: DocViewModel) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = "home"
    ) {
        navigation(route = "home", startDestination = HomeNavRouter.Doc.path) {
            composable(HomeNavRouter.Doc.path) { PediaScreen(navController, docVM) }
            composable(HomeNavRouter.Search.path) { SearchScreen() }
            composable(HomeNavRouter.Setting.path) { SettingScreen() }

        }
        composable(PediaNavRouter.Detail.path) { DetailScreen(navController) }
    }

}