package com.example.smonkey_android.di

import com.example.data.domain.usecase.smonkey.AlterSMonkeyColorUseCase
import com.example.data.domain.usecase.smonkey.MakeSMonkeyUseCase
import com.example.data.domain.usecase.smonkey.SearchSMonkeyUseCase
import com.example.data.remote.datasource.declaration.RemoteSMonkeyDataSource
import com.example.data.remote.datasource.implementation.RemoteSMonkeyDataSourceImpl
import com.example.smonkey_android.feature.SMonkeyViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val sMonkeyModule: Module = module {

    viewModel { SMonkeyViewModel(get(), get(), get()) }

    factory { AlterSMonkeyColorUseCase(get(), get()) }
    factory { MakeSMonkeyUseCase(get(), get()) }
    factory { SearchSMonkeyUseCase(get(), get()) }
    factory<RemoteSMonkeyDataSource> { RemoteSMonkeyDataSourceImpl(get()) }

    single { provideSMonkeyApi(get()) }
}
