// build.gradle.kts (niveau module/app)

plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.example.myapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.myapp"
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

allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io") // Dépôt JitPack
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.11.0")

    // Dépendance JitPack
    implementation("com.github.MeivanK20:My-Immo-1:1.0.0")
}
