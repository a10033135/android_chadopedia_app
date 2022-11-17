package idv.tungfanhall.android_chadopedia_app.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import idv.tungfanhall.android_chadopedia_app.ui.theme.GreenBg700
import idv.tungfanhall.android_chadopedia_app.ui.theme.Shapes

@Composable
fun Head(title: String, content: String, action: String, actionListener: (() -> Unit)) {
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
            text = title,
            color = Color.White
        )

        Text(
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White),
            text = content
        )

        Text(
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .clickable { actionListener.invoke() },
            text = action,
        )
    }
}