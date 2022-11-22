package idv.tungfanhall.android_chadopedia_app.ui.feature.main

import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseUser
import com.socks.library.KLog
import idv.tungfanhall.android_chadopedia_app.model.ItemDetail
import idv.tungfanhall.android_chadopedia_app.model.MainCategory
import idv.tungfanhall.android_chadopedia_app.model.SubCategory
import idv.tungfanhall.android_chadopedia_app.ui.logic.BaseViewModel
import idv.tungfanhall.android_chadopedia_app.utils.FireAuthUtil
import idv.tungfanhall.android_chadopedia_app.utils.FirebaseUtil
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class DocViewModel : BaseViewModel(), Input, Output {

    private val tag = DocViewModel::class.java.simpleName

    val flowMainCategory =
        MutableStateFlow<ApiResult<MutableList<MainCategory>>>(ApiResult.loading())

    val flowSubCategory = MutableStateFlow<ApiResult<MutableList<SubCategory>>>(ApiResult.loading())

    val flowItemDetail = MutableStateFlow<ApiResult<MutableList<ItemDetail>>>(ApiResult.loading())

    val flowCurrentUser = MutableStateFlow<ApiResult<FirebaseUser?>>(ApiResult.loading())

    override fun getMainCategory() {
        KLog.d(tag, "getPediaData")
        viewModelScope.launch {
            val mainCategories =
                FirebaseUtil.document(FirebaseUtil.mainCollection, MainCategory::class.java)
            KLog.e(tag, "mainCategory: $mainCategories")
            flowMainCategory.emit(ApiResult.success(mainCategories))
        }
    }

    override fun getSubCategory(mainCateId: String) {
        viewModelScope.async {
            val collection = FirebaseUtil.subCateCollection
                .whereEqualTo("main_cate_id", mainCateId)
                .whereEqualTo("enable", true)
            val subCategories = FirebaseUtil.document(collection, SubCategory::class.java)
            KLog.e(tag, "subCategory: $subCategories")
            flowSubCategory.emit(ApiResult.success(subCategories))
        }
    }

    override fun getItemDetail(mainCateId: String) {
        viewModelScope.launch {
            val collection = FirebaseUtil.itemDetailCollection
                .whereEqualTo("main_cate_id", mainCateId)
                .whereEqualTo("enable", true)
            val detailItems = FirebaseUtil.document(collection, ItemDetail::class.java)
            KLog.e(tag, "itemDetail: $detailItems")
            flowItemDetail.emit(ApiResult.success(detailItems))
        }
    }

    override fun getCurrentUser() {
        KLog.d(tag, "currentUser")
        viewModelScope.launch {
            flowCurrentUser.emit(ApiResult.loading())
            flowCurrentUser.emit(ApiResult.success(FireAuthUtil.currentUser))
        }
    }

}

interface Input {

    fun getMainCategory()

    fun getSubCategory(mainCateId: String)

    fun getItemDetail(mainCateId: String)

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