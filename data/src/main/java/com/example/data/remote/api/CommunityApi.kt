package com.example.data.remote.api

import com.example.data.remote.request.community.CreateCommunityRequest
import com.example.data.remote.request.community.UpdateCommunityRequest
import com.example.data.remote.response.community.FetchCommunityDetailResponse
import com.example.data.remote.response.community.FetchCommunityResponse
import com.example.data.remote.url.SMonkeyUrl
import com.example.domain.enum.CategoryType
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path
import java.util.UUID

interface CommunityApi {

    @POST(SMonkeyUrl.Community)
    fun createCommunity(
        @Body createCommunityRequest: CreateCommunityRequest
    ): Completable

    @DELETE(SMonkeyUrl.Community)
    fun deleteCommunity(
        @Header("Authorization") accessToken: String,
        @Body id: Int,
    ): Completable

    @PATCH(SMonkeyUrl.Community)
    fun updateCommunity(
        @Header("Authorization") accessToken: String,
        @Body updateCommunityRequest: UpdateCommunityRequest,
    ): Completable

    @GET(SMonkeyUrl.Community)
    fun fetchCommunity(
        @Header("Authorization") accessToken: String,
        @Body category: CategoryType,
    ): Single<FetchCommunityResponse>

    @GET(SMonkeyUrl.Communities.CommunityDetail)
    fun fetchCommunityDetail(
        @Header("Authorization") accessToken: String,
        @Path("feed-id") feedId: UUID,
    ): FetchCommunityDetailResponse

    @POST(SMonkeyUrl.Communities.CommunityLike)
    fun feedLike(
        @Header("Authorization") accessToken: String,
        @Path("feed-id") feedId: UUID,
    ): Completable

    @DELETE(SMonkeyUrl.Communities.CommunityLike)
    fun feedUnLike(
        @Header("Authorization") accessToken: String,
        @Path("feed-id") feedId: UUID,
    ): Completable
}
