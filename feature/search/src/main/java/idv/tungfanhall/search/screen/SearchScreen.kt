package idv.tungfanhall.search.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import idv.tungfanhall.search.R

@Preview
@Composable
internal fun SearchScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Text(text = "日本茶道學習第一站", color = Color.Black)
        Text(text = "茶杓銘、季語、家元等必備術語日文念法通通有，分門別類簡單好查詢，圖文介紹好理解。茶道事典百科－Chadopedia分享給您最正確的日式茶道知識與風雅趣聞。")

    }

}