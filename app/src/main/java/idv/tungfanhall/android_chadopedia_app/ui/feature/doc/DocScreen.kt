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

@OptIn(ExperimentalUnitApi::class)
@Composable
fun Page1(navController: NavController) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        content = {

            item {
                Head()
            }


            val list = mutableListOf<String>()
            for (i in 1..100) {
                list.add(i.toString())
            }
            itemsIndexed(list) { _, item ->
                Column() {
                    stringResource(id = R.string.app_name)

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp)
                            .clickable {
                                Log.e("TAG", "click")
                                navController.navigate(PediaNavRouter.Detail.path)
                            }
                    ) {
                        Text(modifier = Modifier.weight(1f), text = "茶道", fontSize = TextUnit(20F, TextUnitType(20)))
                        Text(modifier = Modifier.weight(1f), text = "描述", fontSize = TextUnit(20F, TextUnitType(20)))
                    }
                    Divider()
                }

            }
        })
}

@Composable
fun Page2() {

    Surface(modifier = Modifier.fillMaxSize()) {
        Text(text = "2")

    }
}

@Composable
fun Head() {
    Column(
        modifier = Modifier
            .wrapContentHeight()
            .padding(20.dp)
            .clip(Shapes.medium)
            .border(0.5.dp, Color.Black)
    ) {
        Text(
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(GreenBg700),
            text = "茶道體驗",
            color = Color.White
        )

        Text(
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White),
            text = "每月480元"
        )

        Text(
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White),
            text = "瞭解詳情"
        )


    }
}