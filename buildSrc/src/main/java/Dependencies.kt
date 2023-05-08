object Dependencies {
    // UI
    private const val androidxCoreKtx = "androidx.core:core-ktx:1.10.0"
    private const val androidLifecycleKtx = "androidx.lifecycle:lifecycle-runtime-ktx:2.6.1"
    private const val androidxAppcompat = "androidx.appcompat:appcompat:1.6.1"
    private const val material = "com.google.android.material:material:1.8.0"
    private const val navigation = "androidx.navigation:navigation-runtime-ktx:2.5.3"

    // Compose
    const val composeBomPlatform = "androidx.compose:compose-bom:2023.03.00"

    private const val composeActivity = "androidx.activity:activity-compose:1.7.1"
    private const val composeUI = "androidx.compose.ui:ui:1.4.2"
    private const val composeUIGraphic = "androidx.compose.ui:ui-graphics"
    private const val composeUITooling = "androidx.compose.ui:ui-tooling:1.4.2"
    private const val composeUIToolingPreview = "androidx.compose.ui:ui-tooling-preview:1.4.2"
    private const val composeMaterial = "androidx.compose.material:material:1.4.2"
    private const val composeMaterial3 = "androidx.compose.material3:material3:1.0.1"
    private const val composeConstraintLayout = "androidx.constraintlayout:constraintlayout-compose:1.0.1"
    private const val composeNavigation = "androidx.navigation:navigation-compose:2.5.3"
    private const val composeCoil = "io.coil-kt:coil-compose:2.2.2"
    private const val composeFoundation = "androidx.compose.foundation:foundation:1.5.0-alpha03"

    val uiLibraries = arrayListOf<String>().apply {
        add(androidxCoreKtx)
        add(androidLifecycleKtx)
        add(androidxAppcompat)
        add(material)
        add(navigation)
    }

    val composeLibraries = arrayListOf<String>().apply {
        add(composeActivity)
        add(composeUI)
        add(composeUIGraphic)
        add(composeUITooling)
        add(composeUIToolingPreview)
        add(composeMaterial)
        add(composeMaterial3)
        add(composeConstraintLayout)
        add(composeNavigation)
        add(composeCoil)
        add(composeFoundation)
    }

    // Android
    private const val coroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4"
    private const val coroutineAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4"

    // LifeCycle
    private const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1"
    private const val lifeCycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:2.6.1"
    private const val activityKtx = "androidx.activity:activity-ktx:1.7.1"
    private const val fragmentKtx = "androidx.fragment:fragment-ktx:1.5.7"

    // Navigation
    private const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:2.5.3"
    private const val navigationUI = "androidx.navigation:navigation-ui-ktx:2.5.3"

    // GMS
    private const val gmsAD = "com.google.android.gms:play-services-ads:22.0.0"
    private const val gmsLocation = "com.google.android.gms:play-services-location:21.0.1"

    // google play core
    private const val googlePlayCore = "com.google.android.play:core:1.10.3"
    private const val googlePlayCoreKtx = "com.google.android.play:core-ktx:1.8.1"

    val androidLibraries = arrayListOf<String>().apply {
        add(coroutineCore)
        add(coroutineAndroid)
        add(viewModelKtx)
        add(lifeCycleRuntime)
        add(activityKtx)
        add(fragmentKtx)
        add(navigationFragment)
        add(navigationUI)
//        add(gmsAD)
//        add(gmsLocation)
        add(googlePlayCore)
        add(googlePlayCoreKtx)
    }

    // Network
    private const val retrofit = "com.squareup.retrofit2:retrofit:2.9.0"
    private const val retrofitConverter = "com.squareup.retrofit2:converter-gson:2.9.0"
    private const val okhttp = "com.squareup.okhttp3:okhttp:4.10.0"
    private const val okhttpLog = "com.squareup.okhttp3:logging-interceptor:4.9.3"

    // gson and auto value
    private const val gson = "com.google.code.gson:gson:2.9.0"

    val networkLibraries = arrayListOf<String>().apply {
        add(retrofit)
        add(retrofitConverter)
        add(okhttp)
        add(okhttpLog)
        add(gson)
    }

    // Firebase
    const val firebaseBom = "com.google.firebase:firebase-bom:32.0.0"

    // firebase auth
    private const val firebaseAuth = "com.google.firebase:firebase-auth-ktx"
    private const val gmsAuth = "com.google.android.gms:play-services-auth:20.5.0"
    private const val firebaseUiAuth = "com.firebaseui:firebase-ui-auth:7.2.0"

    // Firestore
    private const val firestore = "com.google.firebase:firebase-firestore-ktx"

    // cloudinary
    private const val cloudinary = "com.cloudinary:kotlin-url-gen:1.0.0"

    val firebaseLibraries = mutableListOf<String>().apply {
        add(firebaseAuth)
        add(gmsAuth)
        add(firebaseUiAuth)
        add(firestore)
        add(cloudinary)
    }

    // dev tools
    private const val koin = "io.insert-koin:koin-android:3.3.0"
//    private const val klog = "com.github.zhaokaiqiang:klog:-SNAPSHOT"

    val devToolsLibraries = arrayListOf<String>().apply {
        add(koin)
//        add(klog)
    }

    // test
    const val androidTestComposeBom = "androidx.compose:compose-bom:2023.03.00"

    // test
    private const val junit = "junit:junit:4.13.2"
    val testLibraries = arrayListOf<String>().apply {
        add(junit)
    }

    // android test
    private const val androidJunit = "androidx.test.ext:junit:1.1.5"
    private const val androidEspressoCore = "androidx.test.espresso:espresso-core:3.5.1"
    private const val androidComposeUITestJunit = "androidx.compose.ui:ui-test-junit4"
    val androidTestLibraries = arrayListOf<String>().apply {
        add(androidJunit)
        add(androidEspressoCore)
        add(androidComposeUITestJunit)
    }

    // debug
    private const val composeUiTestManifest = "androidx.compose.ui:ui-test-manifest"
    val debugLibraries = arrayListOf<String>().apply {
        add(composeUITooling)
        add(composeUiTestManifest)
    }
}