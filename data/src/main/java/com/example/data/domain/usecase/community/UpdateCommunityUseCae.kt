package com.example.data.domain.usecase.community

import com.example.data.domain.usecase.UseCase
import com.example.data.remote.datasource.declaration.RemoteCommunityDataSource
import com.example.data.remote.request.community.UpdateCommunityParam
import com.example.data.remote.request.community.UpdateCommunityRequest
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

class UpdateCommunityUseCae(
    private val communityDataSource: RemoteCommunityDataSource,
    disposable: CompositeDisposable
) : UseCase<UpdateCommunityParam, Completable>(disposable) {
    override fun buildUseCase(data: UpdateCommunityParam): Single<Completable> =
        communityDataSource.updateCommunity(data)
}
