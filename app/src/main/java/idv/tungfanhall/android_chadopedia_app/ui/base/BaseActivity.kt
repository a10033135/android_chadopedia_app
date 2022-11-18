package idv.tungfanhall.android_chadopedia_app.ui.base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.socks.library.KLog

abstract class BaseActivity : ComponentActivity() {

    abstract val tag: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        KLog.i(tag, "onCreate")
        setContent { ContentView() }
    }

    @Composable
    abstract fun ContentView()


    open fun initAction() {
        KLog.i(tag, "initAction")
    }

    override fun onDestroy() {
        super.onDestroy()
        KLog.i(tag, "onDestroy")
    }

}
