package com.example.smonkey_android.di

import com.example.data.util.ErrorHandler
import com.example.data.util.ErrorHandlerImpl
import io.reactivex.disposables.CompositeDisposable
import org.koin.dsl.module


val baseModule = module {

    factory { CompositeDisposable() }

    factory<ErrorHandler>{ ErrorHandlerImpl() }

}