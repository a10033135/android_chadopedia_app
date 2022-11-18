package idv.tungfanhall.android_chadopedia_app.utils

import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.socks.library.KLog
import kotlinx.coroutines.tasks.await

object FirebaseUtil {

    private val TAG = FirebaseUtil::class.java.simpleName
    private val fireAuth = Firebase.auth
    private val firestore by lazy { Firebase.firestore }

    val isSignUp: Boolean
        get() = fireAuth.currentUser != null

    suspend fun <T> document(docName: String, objClazz: Class<T>): List<T> {
        KLog.e(TAG, "isSignUp: $isSignUp")
        return if (isSignUp) {
            firestore.collection(docName).get().await().documents.mapNotNull {
                it.toObject(objClazz)
            }
        } else {
            mutableListOf()
        }
    }
}