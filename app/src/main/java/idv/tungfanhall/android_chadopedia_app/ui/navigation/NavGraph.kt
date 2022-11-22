package idv.tungfanhall.android_chadopedia_app.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import idv.tungfanhall.android_chadopedia_app.ui.feature.main.DocViewModel
import idv.tungfanhall.android_chadopedia_app.ui.feature.setting.SettingScreen
import idv.tungfanhall.android_chadopedia_app.ui.feature.pedia.PediaScreen
import idv.tungfanhall.android_chadopedia_app.ui.feature.pedia.item.ItemScreen
import idv.tungfanhall.android_chadopedia_app.ui.feature.pedia.main.MainCategoryScreen
import idv.tungfanhall.android_chadopedia_app.ui.feature.pedia.sub.SubCategoryScreen
import idv.tungfanhall.android_chadopedia_app.ui.feature.search.SearchScreen

@Composable
fun NavGraph(modifier: Modifier = Modifier, navController: NavHostController, docVM: DocViewModel) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = "home"
    ) {
        navigation(route = "home", startDestination = HomeNavRouter.Pedia.path) {
            composable(HomeNavRouter.Pedia.path) { PediaScreen(navController, docVM) }
            composable(HomeNavRouter.Search.path) { SearchScreen() }
            composable(HomeNavRouter.Setting.path) { SettingScreen(docVM) }
        }

        composable(PediaNavRouter.MainCategoryScreen.path) {
            MainCategoryScreen(navController = navController, docViewModel = docVM)
        }
        composable(PediaNavRouter.SubCategoriesScreen.path + "/{mainCateId}") {
            val mainCateId = it.arguments?.getString("mainCateId") ?: ""
            SubCategoryScreen(
                navController = navController,
                viewModel = docVM,
                mainCateId = mainCateId
            )
        }
        composable(PediaNavRouter.ItemScreen.path + "/{itemId}") {
            val itemId = it.arguments?.getString("itemId") ?: ""
            ItemScreen(
                navController = navController,
                docVM = docVM,
                itemId = itemId
            )
        }
    }
}