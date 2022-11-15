object Dependencies {
    // UI
    private const val androidxCoreKtx = "androidx.core:core-ktx:${Versions.androidxCore}"
    private const val androidxAppcompat = "androidx.appcompat:appcompat:${Versions.androidxAppccompat}"
    private const val material = "com.google.android.material:material:${Versions.material}"
    private const val refreshLayout = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.refreshLayout}"
    private const val constraintlayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}"
    private const val epoxy = "com.airbnb.android:epoxy:${Versions.epoxy}"
    private const val kkDesignSystem = "com.kkday:design-system:${Versions.kkDesignSystem}"

    // Test
    private const val jUnit = "junit:junit:${Versions.jUnit}"
    private const val androidxExtJunit = "androidx.test.ext:junit:${Versions.androidxExtJunit}"
    private const val androidxEspressoCore = "androidx.test.espresso:espresso-core:${Versions.androidxEspresso}"

    // Rx
    private const val rxJava = "io.reactivex.rxjava2:rxjava:${Versions.rxJava}"
    private const val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid}"
    private const val rxKotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.rxKotlin}"

    // A/B testing
    private const val apptimize = "com.apptimize:apptimize-android:${Versions.apptimize}"

    // Compose
    private const val composeLivedata = "androidx.compose.runtime:runtime-livedata:${Versions.composeLivedata}"
    private const val composeUI = "androidx.compose.ui:ui:${Versions.composeUI}"
    private const val composeMaterial = "androidx.compose.material:material:${Versions.composeMaterial}"
    private const val composeUIToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.composeUIToolingPreview}"
    private const val composeUITooling = "androidx.compose.ui:ui-tooling:${Versions.composeUITooling}"

    // Android
    private const val coroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine}"
    private const val coroutineAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine}"
    private const val iexifinterface =  "androidx.exifinterface:exifinterface:${Versions.iexifinterface}"

    // LifeCycle
    private const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    private const val lifeCycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleRC}"
    private const val activityKtx = "androidx.activity:activity-ktx:${Versions.activityKtx}"
    private const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtx}"

    // Navigation
    private const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    private const val navigationUI = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"

    // GMS
    private const val gmsAD = "com.google.android.gms:play-services-ads:${Versions.gmsAD}"
    private const val gmsAuth = "com.google.android.gms:play-services-auth:${Versions.gmsAuth}"
    private const val gmsLocation = "com.google.android.gms:play-services-location:${Versions.gmsLocation}"
    private const val gmsWallet = "com.google.android.gms:play-services-wallet:${Versions.gmsWallet}"

    // google play core
    private const val googlePlayCore = "com.google.android.play:core:${Versions.googlePlayCore}"

    // Koin
    private const val koin = "io.insert-koin:koin-android:${Versions.koin}"

    // Network
    private const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    private const val retrofitConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    private const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    private const val okhttpLog = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"

    // gson and auto value
    private const val gson = "com.google.code.gson:gson:${Versions.gson}"

    // Other UI
    private const val instagramDot = "ru.tinkoff.scrollingpagerindicator:scrollingpagerindicator:${Versions.instagramDot}"
    private const val fresco = "com.facebook.fresco:fresco:${Versions.fresco}"
    private const val frescoGift = "com.facebook.fresco:animated-gif:${Versions.fresco}"
    private const val frescoWedp = "com.facebook.fresco:animated-webp:${Versions.fresco}"
    private const val frescoImagePipeline = "com.facebook.fresco:imagepipeline-okhttp3:${Versions.fresco}"
    private const val betterLink = "me.saket:better-link-movement-method:${Versions.betterLink}"
    private const val coil = "io.coil-kt:coil-svg:${Versions.coil}"
    private const val flexbox = "com.google.android:flexbox:${Versions.flexbox}"
    private const val adapterDelegate = "com.hannesdorfmann:adapterdelegates3:${Versions.adapterDelegate}"
    private const val spinnerDatePicker = "com.github.drawers:SpinnerDatePicker:${Versions.spinnerDatePicker}"
    private const val badgeview = "cn.bingoogolapple:bga-badgeview:${Versions.spinnerDatePicker}"
    private const val ratingBar = "com.github.wdsqjq:AndRatingBar:${Versions.ratingBar}"
    private const val physicsLayout = "com.github.Jawnnypoo:PhysicsLayout:${Versions.physicsLayout}"
    private const val youtube = "com.pierfrancescosoffritti.androidyoutubeplayer:core:${Versions.youtube}"
    private const val htmlText = "org.sufficientlysecure:html-textview:${Versions.htmlText}"
    private const val recyclerViewSnap = "com.github.rubensousa:gravitysnaphelper:${Versions.recyclerViewSnap}"
    private const val kenburnsview = "com.flaviofaria:kenburnsview:${Versions.kenburnsview}"
    private const val shimmer = "com.facebook.shimmer:shimmer:${Versions.shimmer}"

    // Firebase
    const val firebaseBom = "com.google.firebase:firebase-bom:${Versions.firebaseBom}"
    private const val firebaseCore = "com.google.firebase:firebase-core:${Versions.firebaseCore}"
    private const val firebaseCrashlytics = "com.google.firebase:firebase-crashlytics-ktx${Versions.firebaseCrashlytics}"
    private const val firebaseMessaging = "com.google.firebase:firebase-messaging"
    private const val firebaseAppIndexing = "com.google.firebase:firebase-appindexing"

    // Other Tools
    private const val phoneNumber = "com.googlecode.libphonenumber:libphonenumber:${Versions.phoneNumber}"
    private const val funktionale = "org.funktionale:funktionale-composition:${Versions.funktionale}"
    private const val freshchat = "com.github.freshdesk:freshchat-android:${Versions.freshchat}"
    private const val twilioVoice = "com.twilio:voice-android:${Versions.twilioVoice}"
    private const val twilioConversations = "com.twilio:conversations-android:${Versions.twilioConversations}"
    private const val qrcode = "com.journeyapps:zxing-android-embedded:${Versions.qrcode}"
    private const val desugar = "com.android.tools:desugar_jdk_libs:${Versions.desugar}"

    // Adyen
    private const val adyenCheckoutCard = "com.adyen.checkout:card-ui:${Versions.adyen}"
    private const val adyenCheckoutRedirect = "com.adyen.checkout:redirect:${Versions.adyen}"

    // stripe & credit card & android pay
    private const val stripe = "com.stripe:stripe-android:${Versions.stripe}"

    // AppsFlyer
    private const val appsFlyer = "com.appsflyer:af-android-sdk:${Versions.appsFlyer}"
    private const val installreferrer = "com.android.installreferrer:installreferrer:${Versions.installreferrer}"

    // MixPanel
    private const val mixPanel = "com.mixpanel.android:mixpanel-android:${Versions.mixPanel}"

    // branch
    private const val branch = "io.branch.sdk.android:library:${Versions.branch}"

    // facebook
    private const val facebook = "com.facebook.android:facebook-android-sdk:${Versions.facebook}"

    val uiLibraries = arrayListOf<String>().apply {
        add(androidxCoreKtx)
        add(androidxAppcompat)
        add(material)
        add(refreshLayout)
        add(constraintlayout)
        add(epoxy)
        add(kkDesignSystem)
        add(composeLivedata)
        add(composeUI)
        add(composeMaterial)
        add(composeUIToolingPreview)
        add(composeUITooling)
    }

    val testLibraries = arrayListOf<String>().apply {
        add(jUnit)
        add(androidxExtJunit)
        add(androidxEspressoCore)
    }

    val rxLibraries = arrayListOf<String>().apply {
        add(rxJava)
        add(rxAndroid)
        add(rxKotlin)
    }

    val abTestingLibraries = arrayListOf<String>().apply {
        add(apptimize)
    }

    val androidLibraries = arrayListOf<String>().apply {
        add(coroutineCore)
        add(coroutineAndroid)
        add(iexifinterface)
        add(viewModelKtx)
        add(lifeCycleRuntime)
        add(activityKtx)
        add(fragmentKtx)
        add(navigationFragment)
        add(navigationUI)
        add(gmsAD)
        add(gmsAuth)
        add(gmsLocation)
        add(gmsWallet)
        add(googlePlayCore)
    }

    val koinLibraries = arrayListOf<String>().apply {
        add(koin)
    }

    val networkLibraries = arrayListOf<String>().apply {
        add(retrofit)
        add(retrofitConverter)
        add(okhttp)
        add(okhttpLog)
        add(gson)
    }

    val otherUILibraries = arrayListOf<String>().apply {
        add(instagramDot)
        add(fresco)
        add(frescoGift)
        add(frescoWedp)
        add(frescoImagePipeline)
        add(betterLink)
        add(coil)
        add(flexbox)
        add(adapterDelegate)
        add(spinnerDatePicker)
        add(badgeview)
        add(ratingBar)
        add(physicsLayout)
        add(youtube)
        add(htmlText)
        add(recyclerViewSnap)
        add(kenburnsview)
        add(shimmer)
    }

    val otherToolLibraries = arrayListOf<String>().apply {
        add(instagramDot)
        add(phoneNumber)
        add(funktionale)
        add(freshchat)
        add(twilioVoice)
        add(twilioConversations)
        add(qrcode)
    }

    val firebaseLibraries = arrayListOf<String>().apply {
        add(firebaseMessaging)
        add(firebaseAppIndexing)
    }

    val paymentLibraries = arrayListOf<String>().apply {
        add(adyenCheckoutCard)
        add(adyenCheckoutRedirect)
        add(stripe)
    }

    val trackingLibraries = arrayListOf<String>().apply {
        add(appsFlyer)
        add(installreferrer)
        add(mixPanel)
        add(branch)
        add(facebook)
    }
}