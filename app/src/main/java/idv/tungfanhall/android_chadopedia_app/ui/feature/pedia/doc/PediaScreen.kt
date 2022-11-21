package idv.tungfanhall.android_chadopedia_app.ui.feature.pedia.doc

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import idv.tungfanhall.android_chadopedia_app.R
import idv.tungfanhall.android_chadopedia_app.model.ChadoMainCategory
import idv.tungfanhall.android_chadopedia_app.ui.component.Head
import idv.tungfanhall.android_chadopedia_app.ui.feature.main.ApiResult
import idv.tungfanhall.android_chadopedia_app.ui.feature.main.DocViewModel
import idv.tungfanhall.android_chadopedia_app.ui.navigation.HomeNavRouter
import idv.tungfanhall.android_chadopedia_app.ui.navigation.PediaNavRouter
import idv.tungfanhall.android_chadopedia_app.ui.theme.GreenBg500

@Composable
fun PediaScreen(navController: NavController, docViewModel: DocViewModel) {
    val pedias = docViewModel.flowPedias.collectAsState()
    when (val state = pedias.value) {
        is ApiResult.Empty -> {

        }

        is ApiResult.Loading -> {
            Loading()
        }

        is ApiResult.Loaded -> {

        }

        is ApiResult.Success -> {
            Success(list = state.result) {
                navController.navigate(PediaNavRouter.Detail.path) {
                    popUpTo(HomeNavRouter.Doc.path)
                }
            }
        }

        is ApiResult.Error -> {

        }
    }
}


@Preview
@Composable
private fun Loading() {
    Surface(modifier = Modifier.fillMaxSize()) {
        CircularProgressIndicator(modifier = Modifier.size(30.dp))
    }
}

@OptIn(ExperimentalUnitApi::class)
@Preview
@Composable
private fun Success(
    list: List<ChadoMainCategory> = listOf(), onItemClick: () -> Unit = {}
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(GreenBg500),
        content = {
            item {
                Head(title = "茶道體驗",
                    content = "每月四百八",
                    action = "瞭解詳情",
                    actionListener = {
                        // todo
                    })
            }

            items(list) { item -> RowItem(item, onItemClick) }
        }
    )
}


@Composable
fun RowItem(item: ChadoMainCategory, action: () -> Unit) {
    Column(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .wrapContentHeight()
            .background(Color.White)
            .clickable(onClick = action)
    ) {
        stringResource(id = R.string.app_name)

        Row(
            modifier = Modifier
                .padding(20.dp)
                .height(intrinsicSize = IntrinsicSize.Min)
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = item.title,
                fontSize = 16.sp
            )
            Text(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                textAlign = TextAlign.Center,
                text = item.desc,
                fontSize = 14.sp
            )
        }
        Divider()
    }
}
