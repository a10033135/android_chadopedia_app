package idv.tungfanhall.android_chadopedia_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import idv.tungfanhall.common.theme.Android_chadopedia_appTheme
import idv.tungfanhall.common.ui.BottomBarIcon
import idv.tungfanhall.index.navigation.IndexNavIcon

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Android_chadopedia_appTheme {
                MainScreen()
            }
        }
    }
}

@Preview
@Composable
fun MainScreen() {
    Scaffold(bottomBar = { NavBottomBar() }, content = { paddingValues ->
        Column(
            modifier = Modifier
                .background(color = Color.Black)
                .fillMaxHeight()
                .padding(bottom = paddingValues.calculateBottomPadding())
        ) {

        }
    })
}

@Composable
fun NavBottomBar() {
    BottomNavigation(
        modifier = Modifier.height(60.dp),
        backgroundColor = Color.Gray
    ) {
        IndexNavIcon()
        BottomBarIcon(label = "搜尋", icon = Icons.Rounded.Search)
        BottomBarIcon(label = "設定", icon = Icons.Rounded.Settings)
    }
}

