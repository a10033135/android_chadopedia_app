package idv.tungfanhall.android_chadopedia_app.ui.feature.pedia.sub

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.socks.library.KLog
import idv.tungfanhall.android_chadopedia_app.model.ItemDetail
import idv.tungfanhall.android_chadopedia_app.model.SubCategory
import idv.tungfanhall.android_chadopedia_app.ui.feature.main.ApiResult
import idv.tungfanhall.android_chadopedia_app.ui.feature.main.DocViewModel
import idv.tungfanhall.android_chadopedia_app.ui.navigation.PediaNavRouter
import idv.tungfanhall.android_chadopedia_app.ui.theme.GreenBg500
import idv.tungfanhall.android_chadopedia_app.ui.theme.GreenBg700


@Composable
fun SubCategoryScreen(
    navController: NavController? = null,
    viewModel: DocViewModel,
    mainCateId: String = "",
) {
    val subCategories = viewModel.flowSubCategory.collectAsState()
    val items = viewModel.flowItemDetail.collectAsState()
    viewModel.getSubCategory(mainCateId)
    viewModel.getItemDetail(mainCateId)
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(GreenBg500)
    ) {
        val subCategory = subCategories.value
        val item = items.value
        if (subCategory is ApiResult.Success && item is ApiResult.Success) {
            items(subCategory.result) { subCategory ->
                SubCategoryItem(
                    navController,
                    subCategory,
                    item.result.filter { it.sub_cate_id == subCategory.id })
            }
        }
    }
}

@Preview
@Composable
fun SubCategoryItem(
    navController: NavController? = null,
    subCategory: SubCategory = SubCategory(title = "title"),
    item: List<ItemDetail> = listOf()
) {

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Row(
            modifier = Modifier
                .height(IntrinsicSize.Min)
                .fillMaxWidth()
        ) {
            Text(modifier = Modifier, text = subCategory.title, fontSize = 30.sp)
            Icon(
                modifier = Modifier.fillMaxHeight(),
                imageVector = Icons.Default.Star,
                contentDescription = null
            )
        }


        LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp), content = {
            items(item) {
                GridItem(item = it) {
                    navController?.navigate(PediaNavRouter.ItemScreen.path + "/${it.id}")
                }
            }
        })
    }
}

@Preview
@Composable
fun GridItem(item: ItemDetail = ItemDetail(), action: () -> Unit = {}) {
    Card(
        modifier = Modifier.clickable(enabled = true, onClick = action)
    ) {
        Column(
            modifier = Modifier.width(intrinsicSize = IntrinsicSize.Min),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .size(120.dp)
                    .padding(5.dp),
                alignment = Alignment.Center,
                painter = rememberAsyncImagePainter(item.image_uri),
                contentDescription = null
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                textAlign = TextAlign.Center, text = item.title, color = GreenBg700
            )
        }
    }
}