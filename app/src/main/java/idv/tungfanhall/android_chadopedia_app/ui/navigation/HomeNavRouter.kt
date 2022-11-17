package idv.tungfanhall.android_chadopedia_app.ui.navigation

sealed class HomeNavRouter(val path: String = "home") {

    object Doc : HomeNavRouter("home/doc")
    object Setting : HomeNavRouter("home/setting")
    object Search : HomeNavRouter("home/search")

}

sealed class PediaNavRouter(val path: String = "pedia") {
    object Detail : PediaNavRouter("pedia/detail")

}

