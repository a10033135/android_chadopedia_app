pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "android_chadopedia_app"
include(":app")
include(":common")
include(":core:ui")
include(":core:firebase")
include(":core:data")
include(":feature:index")
include(":feature:search")
include(":feature:search")
