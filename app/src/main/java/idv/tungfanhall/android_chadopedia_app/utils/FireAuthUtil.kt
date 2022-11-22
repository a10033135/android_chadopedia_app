package idv.tungfanhall.android_chadopedia_app.utils

import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

object FireAuthUtil {
    private val TAG = FireAuthUtil::class.java.simpleName
    private val fireAuth by lazy { Firebase.auth }
    val currentUser = fireAuth.currentUser

    val isSignUp: Boolean
        get() = fireAuth.currentUser != null
}