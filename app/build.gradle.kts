import BuildExtensions.androidTestImplementationList
import BuildExtensions.debugImplementationList
import BuildExtensions.implementationList
import BuildExtensions.testImplementationList

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = AppConfig.appNameSpace
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = "idv.tungfanhall.android_chadopedia_app"
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

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
        jvmTarget = AppConfig.jvmTarget
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = AppConfig.ktCompilerVersion
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