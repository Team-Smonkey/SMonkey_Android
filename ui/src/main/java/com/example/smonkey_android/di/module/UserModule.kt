package com.example.smonkey_android.di.module

import com.example.data.domain.usecase.smonkey.AlterSMonkeyColorUseCase
import com.example.data.domain.usecase.smonkey.MakeSMonkeyUseCase
import com.example.data.domain.usecase.smonkey.SearchSMonkeyUseCase
import com.example.data.domain.usecase.user.SignInUseCase
import com.example.data.remote.datasource.declaration.RemoteSMonkeyDataSource
import com.example.data.remote.datasource.declaration.RemoteUserDataSource
import com.example.data.remote.datasource.implementation.RemoteSMonkeyDataSourceImpl
import com.example.data.remote.datasource.implementation.RemoteUserDataSourceImpl
import com.example.smonkey_android.di.provideSMonkeyApi
import com.example.smonkey_android.di.provideUserApi
import com.example.smonkey_android.feature.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val userModule: Module = module {

    viewModel { LoginViewModel(get()) }

    factory { SignInUseCase(get(), get()) }
    factory<RemoteUserDataSource> { RemoteUserDataSourceImpl(get()) }

    single { provideUserApi(get()) }
}