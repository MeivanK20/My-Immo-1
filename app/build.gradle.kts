plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.github.meivank20.myimmo 1"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.github.meivank20.myimmo 1"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation(kotlin("stdlib"))
}
