package idv.tungfanhall.android_chadopedia_app.ui.feature.main

import android.os.Bundle
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.socks.library.KLog
import idv.tungfanhall.android_chadopedia_app.ui.base.BaseActivity
import idv.tungfanhall.android_chadopedia_app.ui.component.NavBottomBar
import idv.tungfanhall.android_chadopedia_app.ui.navigation.NavGraph
import idv.tungfanhall.android_chadopedia_app.ui.navigation.PediaNavRouter
import idv.tungfanhall.android_chadopedia_app.ui.theme.Android_chadopedia_appTheme
import idv.tungfanhall.android_chadopedia_app.ui.theme.GreenBg500
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {

    override val tag: String get() = MainActivity::class.java.simpleName

    private val docVM by viewModel<DocViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initAction()
    }

    @Composable
    override fun ContentView() {
        Android_chadopedia_appTheme {
            val navController = rememberNavController()
            MainScreen(
                navController = navController,
                docViewModel = docVM,
                isBasicRout = navController.currentBackStackEntryAsState().value?.destination?.route?.contains(
                    "home"
                ) == true,
                appBarTitle = "appBarTitle"
            )
        }
    }

    override fun initAction() {
        KLog.d(tag, "initAction")
        docVM.getMainCategory()
        docVM.getCurrentUser()
    }

    @Composable
    fun MainScreen(
        navController: NavHostController,
        docViewModel: DocViewModel,
        isBasicRout: Boolean,
        appBarTitle: String
    ) {
        Scaffold(bottomBar = {
            if (isBasicRout) {
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
                            modifier = Modifier.clickable { navController.navigate(PediaNavRouter.ItemScreen.path) },
                            text = appBarTitle
                        )
                    },
                    navigationIcon = {
                        navController.backQueue.size
                        if (!isBasicRout && navController.previousBackStackEntry != null) {
                            Icon(
                                modifier = Modifier.clickable {
                                    navController.popBackStack()
                                },
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = null
                            )
                        }
                    },
                    modifier = Modifier.height(50.dp),
                    backgroundColor = GreenBg500,
                )
                NavGraph(
                    modifier = Modifier.fillMaxHeight(),
                    navController = navController,
                    docVM = docViewModel
                )
            }
        }
    }
}