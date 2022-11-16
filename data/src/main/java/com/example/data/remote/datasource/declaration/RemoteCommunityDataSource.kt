package com.example.data.remote.datasource.declaration

import com.example.data.domain.enums.CategoryType
import com.example.data.remote.request.community.CreateCommunityRequest
import com.example.data.remote.request.community.UpdateCommunityParam
import com.example.data.remote.request.community.UpdateCommunityRequest
import com.example.data.remote.response.community.FetchCommunityDetailResponse
import com.example.data.remote.response.community.FetchCommunityResponse
import io.reactivex.Completable
import io.reactivex.Single
import java.util.UUID

interface RemoteCommunityDataSource {

    fun createCommunity(createCommunityRequest: CreateCommunityRequest): Single<Completable>

    fun deleteCommunity(id: Int): Single<Completable>

    fun updateCommunity(updateCommunityRequest: UpdateCommunityParam): Single<Completable>

    fun fetchCommunity(category: CategoryType): Single<List<FetchCommunityResponse>>

    fun fetchCommunityDetail(feedId: UUID): Single<FetchCommunityDetailResponse>

    fun feedLike(feedId: UUID): Single<Completable>

    fun feedUnLike(feedId: UUID): Single<Completable>
}