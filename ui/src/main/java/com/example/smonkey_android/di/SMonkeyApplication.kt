package com.example.smonkey_android.di

import android.app.Application
import com.example.smonkey_android.di.module.userModule
import io.reactivex.exceptions.UndeliverableException
import io.reactivex.plugins.RxJavaPlugins
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import java.io.IOException
import java.lang.IllegalArgumentException
import java.lang.IllegalStateException
import java.lang.NullPointerException
import java.net.SocketException

class SMonkeyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        RxJavaPlugins.setErrorHandler {
            if (it is UndeliverableException){

            }
            if (it is IOException ||it is SocketException)
              return@setErrorHandler
            if (it is InterruptedException)
                return@setErrorHandler
            if (it is NullPointerException || it is  IllegalArgumentException){
                Thread.currentThread().uncaughtExceptionHandler
                    ?.uncaughtException(Thread.currentThread(), it)
                return@setErrorHandler

            }
            if (it is IllegalStateException){
                Thread.currentThread().uncaughtExceptionHandler
                    ?.uncaughtException(Thread.currentThread(), it)
                return@setErrorHandler
            }
        }
        startKoin {
            androidContext(this@SMonkeyApplication)
            modules(
                listOf(
                    baseModule,
                    communityModule,
                    friendModule,
                    sMonkeyModule,
                    userModule,
                    networkModule,
                )
            )
        }
    }
}