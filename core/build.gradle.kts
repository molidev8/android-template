import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

@Suppress("DSL_SCOPE_VIOLATION") // Remove when fixed https://youtrack.jetbrains.com/issue/KTIJ-19369
plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk

        testInstrumentationRunner = AppConfig.androidTestInstrumentation
        consumerProguardFiles("consumer-rules.pro")
        if (gradleLocalProperties(rootDir).getProperty("API_KEY") != null) {
            buildConfigField(
                "String",
                "API_KEY",
                gradleLocalProperties(rootDir).getProperty("API_KEY")
            )
        } else {
            buildConfigField("String", "API_KEY", "\"EMPTY\"")
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                AppConfig.proguardRules
            )
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
    api(libs.androidx.core.ktx)
    api(libs.bundles.androidx.room)
    api(libs.retrofit)
    api(libs.okhttp)
    api(libs.gson)
    api(libs.hilt)

    // Compose
    api(platform(libs.androidx.compose.bom))
    api(libs.androidx.compose.activity)
    api(libs.androidx.compose.foundation)
    api(libs.androidx.compose.material3)
    api(libs.androidx.compose.preview)
    api(libs.androidx.compose.ui)
    api(libs.androidx.compose.viewmodel)

    // Firebase
    implementation(platform(libs.google.firebase.bom))
    implementation(libs.google.firebase.crashlytics)
}