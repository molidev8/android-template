import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id(GradlePlugin.androidLibrary)
    id(GradlePlugin.kotlinAndroid)
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
            buildConfigField("String","API_KEY", "\"EMPTY\"")
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

    implementation(Dependencies.roomKtx)
    implementation(Dependencies.roomRuntime)
    implementation(Dependencies.retrofit)
    implementation(Dependencies.okHttp)
    implementation(Dependencies.gson)
    implementation(Dependencies.hilt)

}