package com.example.data.domain.usecase.community

import com.example.data.domain.usecase.UseCase
import com.example.data.remote.datasource.declaration.RemoteCommunityDataSource
import com.example.data.remote.request.community.CreateCommunityRequest
import com.example.data.remote.request.smonkey.MakeSMonkeyRequest
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

class CreateCommunityUseCase(
    private val communityDataSource: RemoteCommunityDataSource,
    disposable: CompositeDisposable
) : UseCase<CreateCommunityRequest, Completable>(disposable) {
    override fun buildUseCase(data: CreateCommunityRequest): Single<Completable> =
        communityDataSource.createCommunity(data)
}
