package com.example.data.domain.usecase.community

import com.example.data.domain.usecase.UseCase
import com.example.data.remote.datasource.declaration.RemoteCommunityDataSource
import com.example.data.remote.response.community.FetchCommunityDetailResponse
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import java.util.UUID

class FetchDetailCommunityUseCase(
    private val communityDataSource: RemoteCommunityDataSource,
    disposable: CompositeDisposable
) : UseCase<UUID, FetchCommunityDetailResponse>(disposable) {
    override fun buildUseCase(data: UUID): Single<FetchCommunityDetailResponse> =
        communityDataSource.fetchCommunityDetail(data)
}
