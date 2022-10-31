object Dependencies {
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val androidKtx = "androidx.activity:activity-ktx:${Versions.androidKtx}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtx}"
    const val material = "com.google.android.material:material:${Versions.material}"

    object UI {
        const val material = "com.google.android.material:material:${Versions.material}"
        const val constraintLayout =
            "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    }

    object ViewModel {
        const val viewModel =
            "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.viewModel}"
        const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    }

    object Navigation {
        const val navigationFragment =
            "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
        const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    }

    object WorkManager {
        const val ktx = "androidx.work:work-runtime-ktx:${Versions.workManager}"
        const val hiltExtension = "androidx.hilt:hilt-work:${Versions.workManagerHiltExtension}"
    }

    object CircleImageView {
        const val circleImage = "de.hdodenhof:circleimageview:${Versions.circleImage}"
    }

    object Moshi {
        const val moshi = "com.squareup.moshi:moshi:${Versions.moshi}"
        const val moshiCompiler = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}"
        const val moshiKotlin = "com.squareup.moshi:moshi-kotlin:${Versions.moshiKotlin}"
    }

    object Coroutine {
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine}"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine}"
    }

    object DI {
        const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hilt}"
        const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
        const val inject = "javax.inject:javax.inject:1"
        const val hiltCompose = "androidx.hilt:hilt-navigation-compose:${Versions.hiltCompose}"
    }

    object Network {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
        const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
    }

    object LocalStorage {
        const val room = "androidx.room:room-ktx:${Versions.room}"
        const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
        const val sharedPreference =
            "androidx.preference:preference-ktx:${Versions.sharedPreference}"
    }

    object Lifecycle {
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
        const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
        const val runTime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    }

    object GradlePlugin {
        const val android = "com.android.tools.build:gradle:${Versions.gradle}"
        const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
        const val hilt = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"
        const val service = "com.google.gms:google-services:${Versions.service}"
    }
}