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

    object RxJava {
        const val rxAndroid = "io.reactivex.rxjava3:rxandroid:${Versions.rxAndroid}"

        const val rxJava = "io.reactivex.rxjava3:rxjava:${Versions.rxJava}"
        const val rxJava3 = "com.squareup.retrofit2:adapter-rxjava3:${Versions.rxJava3}"

        const val rxKotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.rxKotlin}"

        const val rxJava2 = "com.squareup.retrofit2:adapter-rxjava2:${Versions.rxJava2}"
        const val rxDogTag = "com.uber.rxdogtag2:rxdogtag:${Versions.rxDogTag}"
        const val rxBinding = "com.jakewharton.rxbinding4:rxbinding-material:${Versions.rxBinding}"
    }

    object DI {
        const val koinCore = "io.insert-koin:koin-core:${Versions.koinVersion}"
        const val koinScope = "io.insert-koin:koin-androidx-scope:2.1.6"
        const val koin = "io.insert-koin:koin-android:${Versions.koinVersion}"
        const val koinViewModel = "io.insert-koin:koin-androidx-viewmodel:${Versions.koinVersion}"
        const val koinTest = "io.insert-koin:koin-test:${Versions.koinVersion}"
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