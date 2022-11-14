package com.example.data.domain.usecase.community

import com.example.data.domain.usecase.UseCase
import com.example.data.remote.datasource.declaration.RemoteCommunityDataSource
import com.example.data.remote.request.community.UpdateCommunityRequest
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

class DeleteCommunityUseCase(
    private val communityDataSource: RemoteCommunityDataSource,
    disposable: CompositeDisposable
) : UseCase<Int, Completable>(disposable) {
    override fun buildUseCase(data: Int): Single<Completable> =
        communityDataSource.deleteCommunity(data)
}
