package idv.tungfanhall.android_chadopedia_app.app

import android.app.Application
import idv.tungfanhall.android_chadopedia_app.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            allowOverride(true)
            modules(appModule)
        }
    }


}