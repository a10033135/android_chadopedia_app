package idv.tungfanhall.android_chadopedia_app.model

import com.google.firebase.Timestamp

data class MainCategory(
    val id: String = "",
    val title: String = "",
    val desc: String = "",
    val image_uri: String = "",
    val enable: Boolean = false,
    val create_time: Timestamp = Timestamp.now(),
    val update_time: Timestamp = Timestamp.now(),
)

data class SubCategory(
    val id: String = "",
    val main_cate_id: String = "",
    val title: String = "",
    val desc: String = "",
    val image_uri: String = "",
    val enable: Boolean = false,
    val create_time: Timestamp = Timestamp.now(),
    val update_time: Timestamp = Timestamp.now(),
)

data class ItemDetail(
    val id: String = "",
    val main_cate_id: String = "",
    val sub_cate_id: String = "",
    val title: String = "",
    val desc: String = "",
    val image_uri: String = "",
    val enable: Boolean = false,
    val create_time: Timestamp = Timestamp.now(),
    val update_time: Timestamp = Timestamp.now(),
)

