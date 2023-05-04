package idv.tungfanhall.index.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import idv.tungfanhall.common.ui.card.IntroAppCard

@Preview
@Composable
fun IndexScreen() {

    val uiList = remember { mutableStateListOf("IntroAppCard",) }
    val visibleMap = remember { mutableStateMapOf<Int, Boolean>() }

    LazyColumn(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(color = Color.LightGray)
    ) {
        itemsIndexed(uiList) { index, ui ->
            when (ui) {
                "IntroAppCard" -> {

                    AnimatedVisibility(
                        visible = visibleMap.getOrDefault(index, true), // 設為 false 以隱藏該項目
                        enter = fadeIn(), // 進入動畫效果
                        exit = shrinkVertically(), // 離開動畫效果
                    ) {
                        IntroAppCard(onClick = { visibleMap[index] = false })
                    }
                }

            }
        }
    }
}