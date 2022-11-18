package com.example.data.domain.usecase.friend

import com.example.data.domain.usecase.UseCase
import com.example.data.remote.datasource.declaration.RemoteFriendDataSource
import com.example.data.remote.response.friend.RequestListResponse
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

class RequestListUseCase(
    private val remoteFriendDataSource: RemoteFriendDataSource,
    disposable: CompositeDisposable
) : UseCase<Unit, RequestListResponse>(disposable) {
    override fun buildUseCase(data: Unit): Single<RequestListResponse> =
        remoteFriendDataSource.requestList()
}
