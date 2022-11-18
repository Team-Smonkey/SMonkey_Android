package com.example.data.remote.api

import com.example.data.remote.request.community.CreateCommunityRequest
import com.example.data.remote.request.community.UpdateCommunityRequest
import com.example.data.remote.response.community.FetchCommunityDetailResponse
import com.example.data.remote.response.community.FetchCommunityResponse
import com.example.data.remote.url.SMonkeyUrl
import com.example.data.domain.enums.CategoryType
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.UUID

interface CommunityApi {

    @POST(SMonkeyUrl.Community)
    fun createCommunity(
        @Body createCommunityRequest: CreateCommunityRequest
    ): Single<Completable>

    @DELETE(SMonkeyUrl.Community)
    fun deleteCommunity(
        @Header("Authorization") accessToken: String,
        @Query("feed-id") id: Int,
    ): Single<Completable>

    @PATCH(SMonkeyUrl.Communities.CommunityDetail)
    fun updateCommunity(
        @Header("Authorization") accessToken: String,
        @Path("feed-id") feedId: Int,
        @Body updateCommunityRequest: UpdateCommunityRequest,
    ): Single<Completable>

    @GET(SMonkeyUrl.Communities.CommunityList)
    fun fetchCommunity(
        @Header("Authorization") accessToken: String,
        @Query("category") category: CategoryType,
    ): Single<FetchCommunityResponse>

    @GET(SMonkeyUrl.Communities.CommunityDetail)
    fun fetchCommunityDetail(
        @Header("Authorization") accessToken: String,
        @Path("feed-id") feedId: UUID,
    ): Single<FetchCommunityDetailResponse>

    @POST(SMonkeyUrl.Communities.CommunityLike)
    fun feedLike(
        @Header("Authorization") accessToken: String,
        @Path("feed-id") feedId: UUID,
    ): Single<Completable>

    @DELETE(SMonkeyUrl.Communities.CommunityLike)
    fun feedUnLike(
        @Header("Authorization") accessToken: String,
        @Path("feed-id") feedId: UUID,
    ): Single<Completable>
}
