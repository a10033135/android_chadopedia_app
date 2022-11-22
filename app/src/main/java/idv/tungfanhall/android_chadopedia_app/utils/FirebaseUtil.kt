package idv.tungfanhall.android_chadopedia_app.utils

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.socks.library.KLog
import kotlinx.coroutines.tasks.await

object FirebaseUtil {

    private val TAG = FirebaseUtil::class.java.simpleName

    private val firestore by lazy { Firebase.firestore }

    private val pediaCollection: DocumentReference
        get() = firestore.collection("pedia").document("Cf4UiunE03HVWGGnb93H")

    val mainCollection get() = pediaCollection.collection("MainCate")

    val subCateCollection get() = pediaCollection.collection("SubCate")

    val itemDetailCollection get() = pediaCollection.collection("ItemDetail")

    suspend fun <T> document(collection: Query, objClazz: Class<T>): MutableList<T> {
        KLog.e(TAG, "isSignUp: ${FireAuthUtil.isSignUp}")
        val documents = collection.get().await().documents
        KLog.e(TAG, documents)
        return documents.map { it.toObject(objClazz) }.filterNotNull().toMutableList()
    }
}