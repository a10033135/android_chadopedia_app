package idv.tungfanhall.android_chadopedia_app.ui.feature.main

import androidx.lifecycle.viewModelScope
import com.socks.library.KLog
import idv.tungfanhall.android_chadopedia_app.model.PediaDocument
import idv.tungfanhall.android_chadopedia_app.ui.logic.BaseViewModel
import idv.tungfanhall.android_chadopedia_app.utils.FirebaseUtil
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class DocViewModel : BaseViewModel(), Input, Output {

    private val tag = DocViewModel::class.java.simpleName

    val flowPedias = MutableStateFlow<ApiResult<List<PediaDocument>>>(ApiResult.loading())

    override fun getPediaData() {
        KLog.d(tag, DocViewModel::class.java.simpleName)
        viewModelScope.launch {
            flowPedias.emit(ApiResult.loading())
            val pedias = FirebaseUtil.document("pedia", PediaDocument::class.java)
            flowPedias.emit(ApiResult.success(pedias))
        }
    }

}

interface Input {

    fun getPediaData()
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