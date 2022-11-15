package idv.tungfanhall.android_chadopedia_app.feature.login

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import idv.tungfanhall.android_chadopedia_app.ui.theme.GreenBg500

class LoginActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .background(GreenBg500)
            ) {
                Column() {
                    Text(text = "Google登入")
                    Text(text = "帳號密碼登入")
                }
            }

        }
    }
}