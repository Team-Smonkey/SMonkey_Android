package com.example.smonkey_android.di

import com.example.data.domain.usecase.community.CreateCommunityUseCase
import com.example.data.domain.usecase.community.DeleteCommunityUseCase
import com.example.data.domain.usecase.community.FetchCommunityUseCase
import com.example.data.domain.usecase.community.UpdateCommunityUseCae
import com.example.data.remote.datasource.declaration.RemoteCommunityDataSource
import com.example.data.remote.datasource.implementation.RemoteCommunityDataSourceImpl
import com.example.smonkey_android.feature.community.CommunityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val communityModule: Module = module {

    viewModel { CommunityViewModel(get(), get(), get(), get()) }

    factory { FetchCommunityUseCase(get(),get()) }
    factory { UpdateCommunityUseCae(get(), get()) }
    factory { DeleteCommunityUseCase(get(), get()) }
    factory { CreateCommunityUseCase(get(), get()) }
    factory<RemoteCommunityDataSource> { RemoteCommunityDataSourceImpl(get()) }

    single { provideCommunityApi(get()) }
}
