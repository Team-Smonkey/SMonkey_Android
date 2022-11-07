import java.util.regex.Pattern.compile

plugins {
    id ("com.android.application")
    id ("kotlin-android")
    kotlin("kapt")
}

android {
    compileSdk = Project.compileSdk

    defaultConfig {
        applicationId = "com.example.smonkey_android"
        minSdk = Project.minSdk
        targetSdk = Project.targetSdk
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = Project.javaVersion
        targetCompatibility = Project.javaVersion
    }
    kotlinOptions {
        jvmTarget = ("1.8")
    }
    buildFeatures {
        dataBinding = true
    }
}

dependencies {

    implementation(project(":domain"))

    implementation(Dependencies.coreKtx)
    implementation(Dependencies.appcompat)
    implementation(Dependencies.androidKtx)
    implementation(Dependencies.fragmentKtx)
    implementation(Dependencies.material)

    implementation(Dependencies.DI.hiltAndroid)
    implementation(Dependencies.DI.hiltCompose)
    implementation("androidx.appcompat:appcompat:1.5.1")
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    kapt(Dependencies.DI.hiltCompiler)
    implementation(Dependencies.DI.inject)

    implementation(Dependencies.Navigation.navigationUi)
    implementation(Dependencies.Navigation.navigationFragment)

    implementation(Dependencies.CircleImageView.circleImage)

    implementation(Dependencies.Network.retrofit)
    implementation(Dependencies.Network.gsonConverter)
    implementation(Dependencies.Network.okhttp)
    implementation(Dependencies.Network.loggingInterceptor)

    implementation(Dependencies.WorkManager.ktx)
    implementation(Dependencies.WorkManager.hiltExtension)

    implementation(Dependencies.Coroutine.core)
    implementation(Dependencies.Coroutine.android)

    implementation(Dependencies.UI.constraintLayout)
    implementation(Dependencies.UI.material)

    implementation(Dependencies.ViewModel.viewModel)
    implementation(Dependencies.ViewModel.liveData)

    implementation(Dependencies.Lifecycle.viewModel)
    implementation(Dependencies.Lifecycle.liveData)
    implementation(Dependencies.Lifecycle.runTime)

    implementation ("com.dinuscxj:circleprogressbar:1.3.6")
}