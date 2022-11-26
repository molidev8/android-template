plugins {
    id(GradlePlugin.androidApplication)
    id(GradlePlugin.kotlinAndroid)
}

android {
    compileSdk = AppConfig.compileSdk
    buildToolsVersion = AppConfig.buildToolsVersion

    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.readVersionCode(rootProject.projectDir.path)
        versionName = AppConfig.readVersionName(rootProject.projectDir.path)

        testInstrumentationRunner = AppConfig.androidTestInstrumentation
        vectorDrawables.useSupportLibrary = true
    }

    /*signingConfigs {
        create("release") {
            keyAlias = ""
            keyPassword = ""
            storeFile = file("")
            storePassword = ""
        }
    }*/

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
//            signingConfig = signingConfigs.getByName("release")
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
//        viewBinding = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.2"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(ModuleDependencies.coreModule))
    implementation(project(ModuleDependencies.featureHome))

    implementation(Dependencies.coreKtx)
    implementation(Dependencies.lifecycle)
    implementation(Dependencies.composeUI)
    implementation(Dependencies.composeMaterial3)
    implementation(Dependencies.composePreview)
    implementation(Dependencies.lifecycleKtx)
    implementation(Dependencies.viewModel)
    implementation(Dependencies.liveData)
    implementation(Dependencies.composeActivity)
    implementation(Dependencies.hilt)
    implementation(Dependencies.firebaseBom)

    /*ViewBinding
    implementation(Dependencies.appCompat)
    implementation(Dependencies.fragment)
    implementation(Dependencies.constraintLayout)
    implementation(Dependencies.material)
    implementation(Dependencies.navigationUi)
    implementation(Dependencies.navigationFragment)*/

    debugImplementation(Dependencies.composeTooling)

}