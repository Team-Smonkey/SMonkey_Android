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

    implementation(project(":data"))

    implementation(Dependencies.coreKtx)
    implementation(Dependencies.appcompat)
    implementation(Dependencies.androidKtx)
    implementation(Dependencies.fragmentKtx)
    implementation(Dependencies.material)

    implementation("androidx.appcompat:appcompat:1.5.1")
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    implementation(Dependencies.Navigation.navigationUi)
    implementation(Dependencies.Navigation.navigationFragment)

    implementation(Dependencies.CircleImageView.circleImage)

    implementation(Dependencies.Network.retrofit)
    implementation(Dependencies.Network.gsonConverter)
    implementation(Dependencies.Network.okhttp)
    implementation(Dependencies.Network.loggingInterceptor)

    implementation(Dependencies.WorkManager.ktx)
    implementation(Dependencies.WorkManager.hiltExtension)

    implementation(Dependencies.RxJava.rxAndroid)
    implementation(Dependencies.RxJava.rxJava)
    implementation(Dependencies.RxJava.rxJava2)
    implementation(Dependencies.RxJava.rxJava3)
    implementation(Dependencies.RxJava.rxBinding)
    implementation(Dependencies.RxJava.rxKotlin)
    implementation(Dependencies.RxJava.rxDogTag)
    implementation ("io.reactivex.rxjava2:rxandroid:2.0.1")

    implementation(Dependencies.UI.constraintLayout)
    implementation(Dependencies.UI.material)

    implementation(Dependencies.ViewModel.viewModel)
    implementation(Dependencies.ViewModel.liveData)

    implementation(Dependencies.Lifecycle.viewModel)
    implementation(Dependencies.Lifecycle.liveData)
    implementation(Dependencies.Lifecycle.runTime)

    implementation ("org.koin:koin-androidx-viewmodel:${Versions.koinVersion}")

    implementation ("com.dinuscxj:circleprogressbar:1.3.6")
    implementation("androidx.preference:preference-ktx:1.2.0")
}