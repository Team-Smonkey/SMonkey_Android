package com.example.data.domain.usecase.community

import com.example.data.domain.enums.CategoryType
import com.example.data.domain.usecase.UseCase
import com.example.data.remote.datasource.declaration.RemoteCommunityDataSource
import com.example.data.remote.request.community.UpdateCommunityRequest
import com.example.data.remote.response.community.FetchCommunityResponse
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

class FetchCommunityUseCase(
    private val communityDataSource: RemoteCommunityDataSource,
    disposable: CompositeDisposable
) : UseCase<CategoryType, FetchCommunityResponse>(disposable) {
    override fun buildUseCase(data: CategoryType): Single<FetchCommunityResponse> =
        communityDataSource.fetchCommunity(data)
}
