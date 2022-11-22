package idv.tungfanhall.android_chadopedia_app.ui.component

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
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

        MainBtmNaviIcon(
            label = "首頁",
            icon = Icons.Rounded.Home,
            isSelected = HomeNavRouter.Pedia.path == currentRoute
        ) {
            navController.navigate(HomeNavRouter.Pedia.path) { popUpTo(HomeNavRouter.Pedia.path) }
        }

        MainBtmNaviIcon(
            label = "搜尋",
            icon = Icons.Rounded.Search,
            isSelected = HomeNavRouter.Search.path == currentRoute
        ) {
            navController.navigate(HomeNavRouter.Search.path) { popUpTo(HomeNavRouter.Pedia.path) }
        }

        MainBtmNaviIcon(
            label = "設定",
            icon = Icons.Rounded.Settings,
            isSelected = HomeNavRouter.Setting.path == currentRoute
        ) {
            navController.navigate(HomeNavRouter.Setting.path) { popUpTo(HomeNavRouter.Pedia.path) }
        }
    }
}

@Composable
private fun RowScope.MainBtmNaviIcon(label: String, icon: ImageVector, isSelected: Boolean, onClick: () -> Unit) {
    BottomNavigationItem(
        label = { Text(text = label) },
        icon = {
            Icon(
                modifier = Modifier.size(30.dp),
                imageVector = icon,
                contentDescription = label
            )
        },
        selected = isSelected,
        selectedContentColor = GreenBg700,
        unselectedContentColor = Color.Gray,
        onClick = onClick,
    )
}