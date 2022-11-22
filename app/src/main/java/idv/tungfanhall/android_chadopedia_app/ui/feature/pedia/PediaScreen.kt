package idv.tungfanhall.android_chadopedia_app.ui.feature.pedia

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import idv.tungfanhall.android_chadopedia_app.ui.feature.pedia.main.MainCategoryScreen
import idv.tungfanhall.android_chadopedia_app.ui.feature.main.DocViewModel
import idv.tungfanhall.android_chadopedia_app.ui.feature.pedia.sub.SubCategoryScreen
import idv.tungfanhall.android_chadopedia_app.ui.navigation.PediaNavRouter
import idv.tungfanhall.android_chadopedia_app.ui.theme.GreenBg500
import idv.tungfanhall.android_chadopedia_app.ui.theme.GreenBg700
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun PediaScreen(
    navController: NavController,
    docVM: DocViewModel
) {

    val pages = mutableListOf("TAB 1", "TAB 2")

    Surface(modifier = Modifier.fillMaxSize(), color = GreenBg500) {
        Column {
            val pagerState = rememberPagerState()
            val scope = rememberCoroutineScope()

            TabRow(
                modifier = Modifier.wrapContentHeight(),
                backgroundColor = GreenBg500,
                indicator = { tabPositions ->
                    TabRowDefaults.Indicator(
                        modifier = Modifier.tabIndicatorOffset(tabPositions[pagerState.currentPage]),
                        color = GreenBg700
                    )
                },
                divider = { TabRowDefaults.Divider(color = Color.Gray) },
                selectedTabIndex = pagerState.currentPage, tabs = {
                    pages.forEachIndexed { index, value ->
                        Tab(
                            text = { Text(text = value, color = GreenBg700) },
                            selected = index == pagerState.currentPage,
                            onClick = {
                                scope.launch {
                                    pagerState.animateScrollToPage(index)
                                }
                            })
                    }
                })

            HorizontalPager(count = pages.size, state = pagerState) {
                when (it) {
                    0 -> {
                        MainCategoryScreen(navController = navController, docViewModel = docVM)
                    }

                    1 -> {
                        SubCategoryScreen(navController, docVM)
                    }
                }
            }
        }
    }

}