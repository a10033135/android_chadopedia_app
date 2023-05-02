import BuildExtensions.androidTestImplementationList
import BuildExtensions.debugImplementationList
import BuildExtensions.implementationList
import BuildExtensions.testImplementationList

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "idv.tungfanhall.android_chadopedia_app"
    compileSdk = 33

    defaultConfig {
        applicationId = "idv.tungfanhall.android_chadopedia_app"
        minSdk = 28
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
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
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
    testImplementationList(Dependencies.testLibraries)
    androidTestImplementationList(Dependencies.androidTestLibraries)
    debugImplementationList(Dependencies.debugLibraries)
}