package idv.tungfanhall.android_chadopedia_app.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import idv.tungfanhall.android_chadopedia_app.ui.theme.GreenBg700
import idv.tungfanhall.android_chadopedia_app.ui.theme.Shapes

@Preview
@Composable
fun Head(
    title: String = "標題",
    content: String = "內容",
    action: String = "行動",
    actionListener: (() -> Unit) = {}
) {
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
                .background(GreenBg700)
                .padding(12.dp),
            text = title,
            color = Color.White
        )

        Text(
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(12.dp),
            text = content
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(48.dp, 10.dp),
            border = BorderStroke(0.5.dp, GreenBg700)
        ) {
            Text(
                textAlign = TextAlign.Center,
                color = GreenBg700,
                fontSize = 18.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(12.dp)
                    .clickable { actionListener.invoke() },
                text = action,
            )
        }
    }
}