package idv.tungfanhall.android_chadopedia_app.feature.login

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.lifecycleScope
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.Identity
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import idv.tungfanhall.android_chadopedia_app.R
import idv.tungfanhall.android_chadopedia_app.ui.theme.GreenBg500
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.asDeferred
import kotlinx.coroutines.tasks.await

class LoginActivity : ComponentActivity() {

    private val TAG = LoginActivity::class.java.simpleName
    private val signInClient by lazy { Identity.getSignInClient(this) }

    private val loginResultLauncher: ActivityResultLauncher<IntentSenderRequest> =
        registerForActivityResult(ActivityResultContracts.StartIntentSenderForResult()) { result ->
            val auth = Firebase.auth
            val googleCredential = signInClient.getSignInCredentialFromIntent(result.data)
            val idToken = googleCredential.googleIdToken ?: return@registerForActivityResult
            val firebaseCredential = GoogleAuthProvider.getCredential(idToken, null)
            lifecycleScope.launch {
                try {
                    val signIn = auth.signInWithCredential(firebaseCredential).await()
                    finish()
                } catch (e: Exception) {

                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)
        setContent {
            LoginScreen(::onLogin)
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    private fun onLogin(severClientId: String) {
        val signInRequest = BeginSignInRequest.builder()
            .setGoogleIdTokenRequestOptions(
                BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                    .setSupported(true)
                    .setServerClientId(severClientId)
                    .setFilterByAuthorizedAccounts(false)
                    .build()
            )
            .build()

        lifecycleScope.launch {
            val beginSignInRequest = signInClient.beginSignIn(signInRequest).asDeferred()
            beginSignInRequest.getCompletionExceptionOrNull()

        }

        signInClient.beginSignIn(signInRequest)
            .addOnSuccessListener { result ->
                Log.e("TAG", "BeginSignInResult")
                val intentSenderRequest = IntentSenderRequest.Builder(result.pendingIntent).build()
                loginResultLauncher.launch(intentSenderRequest)

            }
            .addOnFailureListener {
                Log.e("TAG", it.message ?: "Not Message")
            }

    }
}

@Composable
fun LoginScreen(onLogin: ((String) -> Unit)) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(GreenBg500)
    ) {
        Column {
            val id = stringResource(R.string.firebase_client_id)
            Text(modifier = Modifier.clickable { onLogin.invoke(id) }, text = "Google登入")
            Text(text = "帳號密碼登入")
        }
    }
}