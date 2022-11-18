package idv.tungfanhall.android_chadopedia_app.di

import idv.tungfanhall.android_chadopedia_app.ui.feature.main.DocViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module {
    // ViewModel for Detail View
    viewModel { DocViewModel() }
}