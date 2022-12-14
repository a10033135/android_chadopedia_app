plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
}

android {
    namespace = "idv.tungfanhall.android_chadopedia_app"
    compileSdk = 33

    defaultConfig {
        applicationId = "idv.tungfanhall.android_chadopedia_app"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.1"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.5.1")
    implementation("androidx.activity:activity-compose:1.6.1")
    implementation("androidx.compose.ui:ui:1.3.1")
    implementation("androidx.compose.ui:ui-tooling-preview:1.3.1")
    implementation("androidx.compose.material:material:1.3.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.4")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.0")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.3.1")
    debugImplementation("androidx.compose.ui:ui-tooling:1.3.1")
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.3.1")

    implementation("androidx.navigation:navigation-compose:2.5.3")
    implementation("com.google.accompanist:accompanist-pager:0.23.1")
    implementation("com.google.firebase:firebase-analytics-ktx")

    // firebase
    implementation(platform("com.google.firebase:firebase-bom:31.0.3"))
    implementation("com.google.firebase:firebase-analytics-ktx")

    // firebase auth
    implementation("com.google.firebase:firebase-auth-ktx")
    implementation("com.google.android.gms:play-services-auth:20.3.0")
    implementation("com.firebaseui:firebase-ui-auth:7.2.0")

    // firestore
    implementation("com.google.firebase:firebase-firestore-ktx:24.4.1")

    // koin
    implementation("io.insert-koin:koin-android:3.3.0")
    implementation("com.github.zhaokaiqiang:klog:-SNAPSHOT")
}