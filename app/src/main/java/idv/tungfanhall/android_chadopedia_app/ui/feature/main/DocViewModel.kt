package idv.tungfanhall.android_chadopedia_app.ui.feature.main

import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseUser
import com.socks.library.KLog
import idv.tungfanhall.android_chadopedia_app.model.ChadoMainCategory
import idv.tungfanhall.android_chadopedia_app.ui.logic.BaseViewModel
import idv.tungfanhall.android_chadopedia_app.utils.FirebaseUtil
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class DocViewModel : BaseViewModel(), Input, Output {

    private val tag = DocViewModel::class.java.simpleName

    val flowPedias =
        MutableStateFlow<ApiResult<MutableList<ChadoMainCategory>>>(ApiResult.loading())

    val flowCurrentUser = MutableStateFlow<ApiResult<FirebaseUser?>>(ApiResult.loading())

    override fun getPediaData() {
        KLog.d(tag, "getPediaData")
        viewModelScope.launch {
            flowPedias.emit(ApiResult.loading())
            val pedias = FirebaseUtil.document("pedia", ChadoMainCategory::class.java)
            flowPedias.emit(ApiResult.success(pedias))
        }
    }

    override fun getCurrentUser() {
        KLog.d(tag, "currentUser")
        viewModelScope.launch {
            flowCurrentUser.emit(ApiResult.loading())
            val user = FirebaseUtil.currentUser
            flowCurrentUser.emit(ApiResult.success(user))
        }
    }

}

interface Input {

    fun getPediaData()

    fun getCurrentUser()
}

interface Output {

}


//        lifecycleScope.launch {
//            val firestore = Firebase.firestore
//            val pedias = firestore.collection("pedia").get().await()
//            val collections = pedias.documents.map { it.toObject(Collections::class.java) }
//            Log.e(TAG, collections.toString())
//        }
//}