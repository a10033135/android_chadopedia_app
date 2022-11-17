package idv.tungfanhall.android_chadopedia_app.ui.feature.doc.pedia

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import idv.tungfanhall.android_chadopedia_app.R
import idv.tungfanhall.android_chadopedia_app.ui.component.Head
import idv.tungfanhall.android_chadopedia_app.ui.navigation.PediaNavRouter

@OptIn(ExperimentalUnitApi::class)
@Composable
fun Page1(navController: NavController) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        content = {

            item {
                Head(title = "茶道體驗", content = "每月四百八", action = "瞭解詳情", actionListener = {
                    // todo
                })
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