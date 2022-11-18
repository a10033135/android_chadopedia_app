package idv.tungfanhall.android_chadopedia_app.ui.feature.pedia.doc

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import idv.tungfanhall.android_chadopedia_app.R
import idv.tungfanhall.android_chadopedia_app.model.PediaDocument
import idv.tungfanhall.android_chadopedia_app.ui.component.Head
import idv.tungfanhall.android_chadopedia_app.ui.feature.main.ApiResult
import idv.tungfanhall.android_chadopedia_app.ui.feature.main.DocViewModel

@OptIn(ExperimentalUnitApi::class)
@Composable
fun PediaScreen(navController: NavController, docViewModel: DocViewModel) {
    val pedias = docViewModel.flowPedias.collectAsState()
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        content = {
            val state = pedias.value
            when (state) {
                is ApiResult.Empty -> {

                }
                is ApiResult.Loading -> {
                    loading()
                }

                is ApiResult.Loaded -> {

                }
                is ApiResult.Success -> {
                    success(list = state.result)
                }

                is ApiResult.Error -> {

                }
            }
        })

}

private fun LazyListScope.loading() {

}

@OptIn(ExperimentalUnitApi::class)
private fun LazyListScope.success(list: List<PediaDocument>) {
    item {
        Head(title = "茶道體驗",
            content = "每月四百八", action = "瞭解詳情",
            actionListener = {
                // todo
            })
    }

    items(list) { item ->
        Column(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .clickable { }
        ) {
            stringResource(id = R.string.app_name)

            Row(modifier = Modifier.padding(20.dp)) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = item.title,
                    fontSize = TextUnit(20F, TextUnitType(20))
                )
            }
            Divider()
        }
    }
}

