package idv.tungfanhall.android_chadopedia_app.ui.feature.pedia.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import idv.tungfanhall.android_chadopedia_app.ui.feature.main.DocViewModel
import idv.tungfanhall.android_chadopedia_app.ui.theme.GreenBg500

@Preview
@Composable
fun ItemScreen(navController: NavHostController, docVM: DocViewModel, itemId: String) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(GreenBg500)
    ) {
        item { Text(text = "片假名") }
        item { Text(text = "平假名") }
        item {
            Row {
                Text(text = "季節")
                Text(text = "冬")
            }
        }
        item {
            Row {
                Text(text = "季節")
                Text(text = "冬")
            }
        }
        item {
            Text(text = "置中")
        }
        item {
            Image(painter = rememberAsyncImagePainter(model = ""), contentDescription =null)

        }


    }
}