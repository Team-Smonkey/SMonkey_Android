package com.example.data.remote.datasource.implementation

import com.example.data.domain.enums.CategoryType
import com.example.data.domain.token.ACCESS_TOKEN
import com.example.data.remote.api.CommunityApi
import com.example.data.remote.datasource.declaration.RemoteCommunityDataSource
import com.example.data.remote.request.community.CreateCommunityRequest
import com.example.data.remote.request.community.UpdateCommunityParam
import com.example.data.remote.request.community.UpdateCommunityRequest
import com.example.data.remote.response.community.FetchCommunityDetailResponse
import com.example.data.remote.response.community.FetchCommunityResponse
import io.reactivex.Completable
import io.reactivex.Single
import java.util.UUID

class RemoteCommunityDataSourceImpl(
    private val communityApi: CommunityApi
): RemoteCommunityDataSource {
    override fun createCommunity(createCommunityRequest: CreateCommunityRequest): Single<Completable> =
        communityApi.createCommunity(createCommunityRequest)

    override fun deleteCommunity(id: Int): Single<Completable> =
        communityApi.deleteCommunity(
            accessToken = ACCESS_TOKEN,
            id
        )

    override fun updateCommunity(updateCommunityParam: UpdateCommunityParam): Single<Completable> =
        communityApi.updateCommunity(
            accessToken = ACCESS_TOKEN,
            feedId = updateCommunityParam.feed_id,
            UpdateCommunityRequest(
                updateCommunityParam.title,
                updateCommunityParam.content,
                updateCommunityParam.category
            )
        )

    override fun fetchCommunity(category: CategoryType): Single<List<FetchCommunityResponse>> =
        communityApi.fetchCommunity(
            accessToken = ACCESS_TOKEN,
            category
        )

    override fun fetchCommunityDetail(feedId: UUID): Single<FetchCommunityDetailResponse> =
        communityApi.fetchCommunityDetail(
            accessToken = ACCESS_TOKEN,
            feedId
        )

    override fun feedLike(feedId: UUID): Single<Completable> =
        communityApi.feedLike(
            accessToken = ACCESS_TOKEN,
            feedId
        )

    override fun feedUnLike(feedId: UUID): Single<Completable> =
        communityApi.feedUnLike(
            accessToken = ACCESS_TOKEN,
            feedId
        )
}