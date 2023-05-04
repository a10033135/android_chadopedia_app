package idv.tungfanhall.common.ui.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import idv.tungfanhall.common.R

@Preview
@Composable
fun IntroAppCard(onClick: () -> Unit = {}) {
    Column(
        modifier = Modifier
            .padding((12).dp)
            .clip(RoundedCornerShape((24).dp))
            .background(Color.White)
            .fillMaxWidth()
            .wrapContentHeight()
            .padding((12).dp)
    ) {

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                modifier = Modifier.weight(1f),
                text = "日本茶道學習第一站",
                style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.Bold),
                color = Color.Black
            )
            Icon(
                modifier = Modifier
                    .height(IntrinsicSize.Max)
                    .clickable { onClick.invoke() },
                imageVector = Icons.Rounded.Close,
                contentDescription = null,
            )
        }


        Text(
            text = "茶杓銘、季語、家元等必備術語日文念法通通有，分門別類簡單好查詢，圖文介紹好理解。茶道事典百科－Chadopedia分享給您最正確的日式茶道知識與風雅趣聞。"
        )
        Image(
            modifier = Modifier.padding(vertical = (12).dp),
            painter = painterResource(id = R.drawable.home_background_mty1uz),
            contentDescription = "IndexImage"
        )
    }
}