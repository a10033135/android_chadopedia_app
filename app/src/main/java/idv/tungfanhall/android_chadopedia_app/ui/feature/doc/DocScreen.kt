package idv.tungfanhall.android_chadopedia_app.ui.feature.doc

import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import idv.tungfanhall.android_chadopedia_app.R
import idv.tungfanhall.android_chadopedia_app.ui.component.Head
import idv.tungfanhall.android_chadopedia_app.ui.feature.doc.news.Page2
import idv.tungfanhall.android_chadopedia_app.ui.feature.doc.pedia.Page1
import idv.tungfanhall.android_chadopedia_app.ui.navigation.PediaNavRouter
import idv.tungfanhall.android_chadopedia_app.ui.theme.GreenBg500
import idv.tungfanhall.android_chadopedia_app.ui.theme.GreenBg700
import idv.tungfanhall.android_chadopedia_app.ui.theme.Shapes
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun DocScreen(navController: NavController) {

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
                        Page1(navController)
                    }
                    1 -> {
                        Page2()
                    }
                }
            }
        }
    }

}