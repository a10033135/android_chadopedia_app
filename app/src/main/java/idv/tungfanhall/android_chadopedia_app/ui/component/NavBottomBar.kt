package idv.tungfanhall.android_chadopedia_app.ui.component

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.List
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import idv.tungfanhall.android_chadopedia_app.ui.navigation.HomeNavRouter
import idv.tungfanhall.android_chadopedia_app.ui.theme.GreenBg500
import idv.tungfanhall.android_chadopedia_app.ui.theme.GreenBg700

@Composable
fun NavBottomBar(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    BottomNavigation(
        modifier = Modifier.height(60.dp),
        backgroundColor = GreenBg500
    ) {

        val iconSize = 30.dp

        BottomNavigationItem(
            label = { Text(text = "首頁") },
            icon = {
                Icon(
                    modifier = Modifier.size(iconSize),
                    imageVector = Icons.Rounded.List,
                    contentDescription = "首頁"
                )
            },
            selected = HomeNavRouter.Doc.path == currentRoute,
            selectedContentColor = GreenBg700,
            unselectedContentColor = Color.Gray,
            onClick = {
                navController.navigate(HomeNavRouter.Doc.path) {
                    popUpTo(HomeNavRouter.Doc.path)
                }
            },
        )

        BottomNavigationItem(
            label = { Text(text = "設定") },
            icon = {
                Icon(
                    modifier = Modifier.size(iconSize),
                    imageVector = Icons.Rounded.Settings,
                    contentDescription = "設定"
                )
            },
            selected = HomeNavRouter.Setting.path == currentRoute,
            selectedContentColor = GreenBg700,
            unselectedContentColor = Color.Gray,
            onClick = {
                navController.navigate(HomeNavRouter.Setting.path) {
                    popUpTo(HomeNavRouter.Doc.path)
                }
            },
        )
    }
}