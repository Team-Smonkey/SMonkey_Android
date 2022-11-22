package com.example.data.domain.usecase.friend

import com.example.data.domain.usecase.UseCase
import com.example.data.remote.datasource.declaration.RemoteCommunityDataSource
import com.example.data.remote.datasource.declaration.RemoteFriendDataSource
import com.example.data.remote.response.community.FetchCommunityDetailResponse
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import java.util.UUID

class AddFriendUseCase(
    private val remoteFriendDataSource: RemoteFriendDataSource,
    disposable: CompositeDisposable
) : UseCase<Long, Completable>(disposable) {
    override fun buildUseCase(data: Long): Single<Completable> =
        remoteFriendDataSource.addFriend(data)
}
