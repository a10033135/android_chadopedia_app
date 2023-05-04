package idv.tungfanhall.common.ui

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun RowScope.BottomBarIcon(
    label: String,
    icon: ImageVector,
    selected: Boolean = false,
    onClick: () -> Unit = {},
) {
    BottomNavigationItem(
        label = { Text(text = label) },
        icon = {
            Icon(
                modifier = Modifier.size(30.dp),
                imageVector = icon,
                contentDescription = label
            )
        },
        unselectedContentColor = Color.White,
        selectedContentColor = Color.Green,
        onClick = onClick,
        selected = selected
    )
}