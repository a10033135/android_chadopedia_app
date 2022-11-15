package idv.tungfanhall.android_chadopedia_app

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import idv.tungfanhall.android_chadopedia_app.feature.login.LoginActivity
import idv.tungfanhall.android_chadopedia_app.ui.component.NavBottomBar
import idv.tungfanhall.android_chadopedia_app.ui.navigation.NavGraph
import idv.tungfanhall.android_chadopedia_app.ui.navigation.PediaNavRouter
import idv.tungfanhall.android_chadopedia_app.ui.theme.Android_chadopedia_appTheme
import idv.tungfanhall.android_chadopedia_app.ui.theme.GreenBg500
import idv.tungfanhall.android_chadopedia_app.ui.theme.GreenBg700

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


            Android_chadopedia_appTheme {
                val navController = rememberNavController()
                val isShowBtmBar =
                    navController.currentBackStackEntryAsState().value?.destination?.route?.contains("home")


                Scaffold(bottomBar = {
                    if (isShowBtmBar == true) {
                        NavBottomBar(navController)
                    }
                }) {
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(bottom = it.calculateBottomPadding())
                    ) {
                        TopAppBar(
                            title = {
                                Text(
                                    modifier = Modifier.clickable { navController.navigate(PediaNavRouter.Detail.path) },
                                    text = "Chado Pedia"
                                )
                            },
                            actions = {
                                Icon(
                                    modifier = Modifier.clickable {
                                        val intent = Intent(this@MainActivity, LoginActivity::class.java)
                                        startActivity(intent)
                                    },
                                    imageVector = Icons.Default.Add,
                                    contentDescription = null
                                )
                            },
                            modifier = Modifier.height(50.dp),
                            backgroundColor = GreenBg500,
                        )
                        NavGraph(
                            modifier = Modifier.fillMaxHeight(),
                            navController = navController
                        )
                    }
                }
            }
        }
    }
}