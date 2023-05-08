package idv.tungfanhall.common.model.firestore

import com.google.firebase.Timestamp
import com.google.firebase.firestore.DocumentId


data class ChadoContent(
    @DocumentId
    override val doc_id: String = "",
    val title: String = "",
    val desc: String = "",
    val has_image: Boolean = false,
    val enable: Boolean = false,
    val main_categories: List<String> = listOf(),
    val sub_categories: List<String> = listOf(),
    val create_time: Timestamp = Timestamp.now(),
    val update_time: Timestamp = Timestamp.now(),
) : FirestoreInterface {
    override val publicPath: String
        get() = "chado_content/${doc_id}"
}