package com.example.smonkey_android.di

import com.example.data.domain.usecase.friend.AddFriendUseCase
import com.example.data.domain.usecase.friend.FetchFriendListUseCase
import com.example.data.domain.usecase.friend.ReceiveRequestUseCase
import com.example.data.domain.usecase.friend.RefuseRequestUseCase
import com.example.data.domain.usecase.friend.SearchFriendUseCase
import com.example.data.remote.datasource.declaration.RemoteFriendDataSource
import com.example.data.remote.datasource.implementation.RemoteFriendDataSourceImpl
import com.example.smonkey_android.feature.friend.FriendViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val friendModule: Module = module {

    viewModel { FriendViewModel(get(), get(), get(), get(), get()) }

    factory { AddFriendUseCase(get(),get()) }
    factory { FetchFriendListUseCase(get(), get()) }
    factory { ReceiveRequestUseCase(get(), get()) }
    factory { RefuseRequestUseCase(get(), get()) }
    factory { SearchFriendUseCase(get(), get()) }
    factory<RemoteFriendDataSource> { RemoteFriendDataSourceImpl(get()) }

    single { provideFriendApi(get()) }
}
