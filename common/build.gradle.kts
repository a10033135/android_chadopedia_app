import BuildExtensions.implementationList

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "idv.tungfanhall.common"
    compileSdk = 33

    defaultConfig {
        minSdk = 28

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {

    implementation(platform(Dependencies.composeBomPlatform))
    implementationList(Dependencies.uiLibraries)
    implementationList(Dependencies.composeLibraries)
    implementationList(Dependencies.androidLibraries)
    implementationList(Dependencies.networkLibraries)
    implementation(platform(Dependencies.firebaseBom))
    implementationList(Dependencies.firebaseLibraries)
    implementationList(Dependencies.devToolsLibraries)
}