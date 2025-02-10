plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    kotlin("plugin.serialization") version "1.9.22"
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.surivalcoding.composerecipeapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.surivalcoding.composerecipeapp"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)


    // coil
    implementation(libs.coil.compose)
    implementation(libs.coil.network.okhttp)

    // kotlin - serialization
    implementation(libs.kotlinx.serialization.json)

    // viewModel - compose
    implementation(libs.androidx.lifecycle.viewmodel.compose)

    // viewModel - ktx
    implementation(libs.lifecycle.viewmodel.ktx)


    // lottieAnimation
    implementation(libs.lottie.compose)


    // navigation
    implementation(libs.androidx.navigation.compose)

    implementation(libs.androidx.material)


    // Logger
    implementation(libs.logger)


    // hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)


    kapt(libs.androidx.hilt.compiler)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.lifecycle.viewmodel.compose.v285)
    implementation(libs.androidx.hilt.navigation.compose)


    // room
    implementation("androidx.room:room-runtime:2.6.1") // 최신 버전 확인 필요
    kapt("androidx.room:room-compiler:2.6.1") // Annotation Processor (kapt)

    // Kotlin Coroutines 지원 (필수는 아님)
    implementation("androidx.room:room-ktx:2.6.1")

    // dataStore
    implementation("androidx.datastore:datastore-preferences:1.1.1")

    // firebase
    implementation(platform("com.google.firebase:firebase-bom:33.8.0"))
    implementation("com.google.firebase:firebase-analytics-ktx:22.2.0")
    implementation("com.google.firebase:firebase-messaging-ktx:24.1.0")


    // exoplayer
    implementation("androidx.media3:media3-exoplayer:1.3.1")
    implementation("androidx.media3:media3-ui:1.3.1")
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}