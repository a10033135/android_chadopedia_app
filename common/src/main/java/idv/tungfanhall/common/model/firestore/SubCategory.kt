package idv.tungfanhall.common.model.firestore

import com.google.firebase.Timestamp
import com.google.firebase.firestore.DocumentId

data class SubCategory(
    @DocumentId
    override val doc_id: String = "",
    val main_cate_id: String = "",
    val title: String = "",
    val desc: String = "",
    val has_image: Boolean = false,
    val enable: Boolean = false,
    val sort: Int = 0,
    val create_time: Timestamp = Timestamp.now(),
    val update_time: Timestamp = Timestamp.now(),
) : FirestoreInterface {
    override val publicPath: String
        get() = "sub_category/${doc_id}"
}