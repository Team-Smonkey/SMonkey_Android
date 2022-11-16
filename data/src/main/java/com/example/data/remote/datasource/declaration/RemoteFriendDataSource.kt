package com.example.data.remote.datasource.declaration

import com.example.data.remote.response.friend.FriendListResponse
import com.example.data.remote.response.friend.RequestListResponse
import io.reactivex.Completable
import io.reactivex.Single

interface RemoteFriendDataSource {

    fun addFriend(friend_id: String): Single<Completable>

    fun fetchFriendList(): Single<FriendListResponse>

    fun searchFriend(name: String): Single<Completable>

    fun receiveFriend(sender_id: String): Single<Completable>

    fun refuseFriend(sender_id: String): Single<Completable>

    fun requestList(): Single<RequestListResponse>
}
