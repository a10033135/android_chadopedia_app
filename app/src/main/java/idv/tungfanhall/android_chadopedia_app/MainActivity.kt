package idv.tungfanhall.android_chadopedia_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import idv.tungfanhall.common.theme.Android_chadopedia_appTheme
import idv.tungfanhall.common.ui.BottomBarIcon
import idv.tungfanhall.index.navigation.IndexNavIcon
import idv.tungfanhall.index.navigation.indexGraph
import idv.tungfanhall.index.navigation.indexRoute
import idv.tungfanhall.search.navigation.SearchNavIcon
import idv.tungfanhall.search.navigation.searchGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            Android_chadopedia_appTheme {
            MainScreen()
//            }
        }
    }
}

@Preview
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(bottomBar = { NavBottomBar(navController) }, content = { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(bottom = paddingValues.calculateBottomPadding())
        ) {
//            CenterAlignedTopAppBar(
//                title = { Text(text = stringResource(id = titleRes)) },
//                actions = {
//                    IconButton(onClick = onActionClick) {
//                        Icon(
//                            imageVector = actionIcon,
//                            contentDescription = actionIconContentDescription,
//                            tint = MaterialTheme.colorScheme.onSurface,
//                        )
//                    }
//                },
//                colors = colors,
//                modifier = modifier.testTag("niaTopAppBar"),
//            )
            MainNavHost(navController = navController, startDestination = indexRoute, modifier = Modifier)
        }
    })
}

@Composable
fun NavBottomBar(navController: NavHostController) {
    BottomNavigation(
        modifier = Modifier.height(60.dp),
        backgroundColor = Color.Gray
    ) {
        IndexNavIcon(navController)
        SearchNavIcon(navController)
        BottomBarIcon(label = "設定", icon = Icons.Rounded.Settings)
    }
}

@Composable
fun MainNavHost(navController: NavHostController, startDestination: String, modifier: Modifier) {
    NavHost(
        navController = navController,
        startDestination = indexRoute,
        modifier = modifier
    ) {
        indexGraph()
        searchGraph()
    }

}

