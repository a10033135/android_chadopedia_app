object AppConfig {
    const val compileSdk = 31
    const val minSdk = 24
    const val targetSdk = 31

    // Module
    const val abTestingVersionCode = 1
    const val abTestingVersionName = "1.0"

    // Test
    const val androidTestInstrumentation = "androidx.test.runner.AndroidJUnitRunner"

    // Proguard
    const val proguardConsumerRules = "consumer-rules.pro"
    const val proguardFile = "proguard-android-optimize.txt"
    const val proguardRules = "proguard-rules.pro"

    // JVM
    const val jvmTarget = "1.8"
}