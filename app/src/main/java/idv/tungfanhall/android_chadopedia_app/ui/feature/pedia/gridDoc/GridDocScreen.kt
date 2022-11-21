package idv.tungfanhall.android_chadopedia_app.ui.feature.pedia.gridDoc

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import idv.tungfanhall.android_chadopedia_app.ui.theme.GreenBg500
import idv.tungfanhall.android_chadopedia_app.ui.theme.GreenBg700

@Preview
@Composable
fun GridScreen(navController: NavController? = null) {
    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxSize()
            .background(GreenBg500),
        columns = GridCells.Fixed(2)
    ) {
        val item = mutableListOf<String>()
        for (i in 1..30) {
            item.add("")
        }
        items(item) {
            GridItem(
                title = "aaa",
                imageUrl = "https://matchanote-images.s3-ap-northeast-1.amazonaws.com/chashakunomeis/253.png"
            )
        }
    }
}

@Composable
fun GridItem(imageUrl: String, title: String) {
    Card(modifier = Modifier.padding(15.dp)) {
        Column(
            modifier = Modifier.width(intrinsicSize = IntrinsicSize.Min),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (imageUrl.isNotEmpty()) {
                Image(
                    modifier = Modifier.size(60.dp),
                    alignment = Alignment.Center,
                    painter = rememberAsyncImagePainter(imageUrl),
                    contentDescription = null
                )
            }
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                textAlign = TextAlign.Center, text = title, color = GreenBg700
            )
        }
    }
}