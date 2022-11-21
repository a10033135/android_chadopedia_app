package idv.tungfanhall.android_chadopedia_app.model

data class ChadoMainCategory(
    val title: String = "",
    val desc: String = "",
    val imageUri: String = "",
    val updateTime: String = "",
    val enable: Boolean = false,
    val chadoSubCategory: MutableList<ChadoSubCategory> = mutableListOf(),
    val item: MutableList<ChadoItemDetail> = mutableListOf()
) {
    data class ChadoSubCategory(
        val title: String = "",
        val desc: String = "",
        val imageUri: String = "",
        val enable: Boolean,
        val item: MutableList<ChadoItemDetail>,
    )

    data class ChadoItemDetail(
        val title: String = "",
        val desc: String = "",
        val imageUri: String = "",
        val enable: Boolean
    )
}

