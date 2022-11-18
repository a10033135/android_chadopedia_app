package idv.tungfanhall.android_chadopedia_app.ui.feature.setting

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import idv.tungfanhall.android_chadopedia_app.R
import idv.tungfanhall.android_chadopedia_app.ui.feature.main.ApiResult
import idv.tungfanhall.android_chadopedia_app.ui.feature.main.DocViewModel
import idv.tungfanhall.android_chadopedia_app.utils.FirebaseUtil


@Composable
fun SettingScreen(docVM: DocViewModel) {
    val userResult = docVM.flowCurrentUser.collectAsState()
    Surface(modifier = Modifier.fillMaxSize()) {
        when (val state = userResult.value) {
            is ApiResult.Success -> {
                val user = state.result
                if (FirebaseUtil.isSignUp) {
                    LoginScreen(user?.displayName ?: "", user?.email ?: "")
                }
            }

        }

    }
}

@Preview
@Composable
fun LoginScreen(displayName: String = "aaa", email: String = "a10033135@gmail.com") {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
        ) {
            Icon(imageVector = Icons.Rounded.Person, contentDescription = null)
            Column {
                Text(text = displayName)
                Text(text = email)
            }
        }

        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(text = "訂單查詢")
                Text(text = "訂單查詢")
                Text(text = "訂單查詢")
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(text = "訂單查詢")
                Text(text = "訂單查詢")
            }
        }

        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "null"
        )

    }
}

@Preview
@Composable
fun UserInfo() {

}

@Composable
fun NotLoginScreen() {

}

