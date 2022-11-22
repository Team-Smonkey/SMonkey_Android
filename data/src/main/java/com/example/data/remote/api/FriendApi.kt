package com.example.data.remote.api

import com.example.data.remote.response.friend.FriendListResponse
import com.example.data.remote.response.friend.RequestListResponse
import com.example.data.remote.url.SMonkeyUrl
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface FriendApi {

    @POST(SMonkeyUrl.Friend.PathFriend)
    fun addFriend(
        @Header("Authorization") accessToken: String,
        @Path("friend-id") friend_id: Long,
    ): Single<Completable>

    @GET(SMonkeyUrl.Friends)
    fun fetchFriendList(
        @Header("Authorization") accessToken: String,
    ): Single<FriendListResponse>

    @GET(SMonkeyUrl.Friend.FetchFriend)
    fun searchFriend(
        @Header("Authorization") accessToken: String,
        @Body name: String,
    ): Single<Completable>

    @POST(SMonkeyUrl.Friend.ReceiveFriendRequest)
    fun receiveFriend(
        @Header("Authorization") accessToken: String,
        @Query("friend-id") friend_id: Long
    ): Single<Completable>

    @POST(SMonkeyUrl.Friend.RefuseFriendRequest)
    fun refuseFriend(
        @Header("Authorization") accessToken: String,
        @Query("friend-id") friend_id: Long
    ): Single<Completable>

    @GET(SMonkeyUrl.Friend.RequestList)
    fun fetchRequestList(
        @Header("Authorization") accessToken: String,
    ): Single<RequestListResponse>
}