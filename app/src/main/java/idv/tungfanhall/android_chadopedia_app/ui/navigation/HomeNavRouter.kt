package idv.tungfanhall.android_chadopedia_app.ui.navigation

sealed class HomeNavRouter(val path: String = "home") {

    object Pedia : HomeNavRouter("home/pedia")
    object Setting : HomeNavRouter("home/setting")
    object Search : HomeNavRouter("home/search")

}

sealed class PediaNavRouter(val path: String = "pedia") {

    /**
     * 茶杓、茶筅、茶具
     * pedia/
     * */
    object MainCategoryScreen : PediaNavRouter("pedia/")

    /**
     * 選完茶筅，要選 1月、2月、3月、4月，或直接選 A 茶筅
     * pedia/main/{main}
     * */
    object SubCategoriesScreen : PediaNavRouter("pedia/main")

    /**
     * 選完 A 茶筅，顯示商品細節頁面
     * */
    object ItemScreen : PediaNavRouter("pedia/item")

}

