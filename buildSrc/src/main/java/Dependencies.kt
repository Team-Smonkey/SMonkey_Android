object Dependencies {
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val androidKtx = "androidx.activity:activity-ktx:${Versions.androidKtx}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtx}"
    const val material = "com.google.android.material:material:${Versions.material}"

    object UI {
        object Compose {
            const val composeUi = "androidx.compose.ui:ui:${Versions.jetpackCompose}"
            const val composeMaterial = "androidx.compose.material:material:${Versions.jetpackCompose}"
            const val composePreView = "androidx.compose.ui:ui-tooling-preview:${Versions.jetpackCompose}"
            const val composeActivity =
                "androidx.activity:activity-compose:${Versions.activityCompose}"
            const val composeTest = "androidx.compose.ui:ui-test-junit4:${Versions.jetpackCompose}"
            const val composeUiTool = "androidx.compose.ui:ui-tooling:${Versions.jetpackCompose}"

            const val composeNav = "androidx.navigation:navigation-compose:${Versions.nav}"
            const val composeAniNav =
                "com.google.accompanist:accompanist-navigation-animation:${Versions.aniNav}"
            const val accompanistPager =
                "com.google.accompanist:accompanist-pager:${Versions.accompanistPager}"
            const val accompanistIconController =
                "com.google.accompanist:accompanist-systemuicontroller:${Versions.accompanistIconController}"
            const val composeConstraint =
                "androidx.constraintlayout:constraintlayout-compose:${Versions.composeConstraint}"
            const val composeMaterialIcon =
                "androidx.compose.material:material-icons-extended:${Versions.jetpackCompose}"
        }

        object ViewModel {
            const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.viewModel}"
            const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
        }
    }

    object WorkManager {
        const val ktx = "androidx.work:work-runtime-ktx:${Versions.workManager}"
        const val hiltExtension = "androidx.hilt:hilt-work:${Versions.workManagerHiltExtension}"
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