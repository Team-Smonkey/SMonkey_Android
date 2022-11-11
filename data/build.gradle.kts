plugins {
    id ("com.android.library")
    id ("kotlin-android")
    kotlin("kapt")
}

android {
    compileSdk = Project.compileSdk

    defaultConfig {
        minSdk = Project.minSdk
        targetSdk = Project.targetSdk
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {
    implementation(project(":domain"))

    implementation(Dependencies.Moshi.moshi)
    implementation("androidx.room:room-common:2.4.3")
    kapt(Dependencies.Moshi.moshiCompiler)

    implementation ("com.squareup.okhttp3:okhttp:4.9.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.9.0")

    implementation(Dependencies.Network.gsonConverter)
    implementation(Dependencies.Network.loggingInterceptor)
    implementation(Dependencies.Network.retrofit)
    implementation(Dependencies.Network.okhttp)

    implementation(Dependencies.RxJava.rxAndroid)
    implementation(Dependencies.RxJava.rxJava)
    implementation(Dependencies.RxJava.rxJava2)
    implementation(Dependencies.RxJava.rxJava3)
    implementation(Dependencies.RxJava.rxBinding)
    implementation(Dependencies.RxJava.rxKotlin)
    implementation(Dependencies.RxJava.rxDogTag)

    implementation(Dependencies.WorkManager.ktx)
    implementation(Dependencies.WorkManager.hiltExtension)

    implementation(Dependencies.LocalStorage.room)
    annotationProcessor(Dependencies.LocalStorage.roomCompiler)
    implementation(Dependencies.LocalStorage.sharedPreference)
}