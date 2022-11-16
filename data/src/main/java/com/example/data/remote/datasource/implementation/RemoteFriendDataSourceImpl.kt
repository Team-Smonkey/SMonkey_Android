package com.example.data.remote.datasource.implementation

import com.example.data.domain.token.ACCESS_TOKEN
import com.example.data.remote.api.FriendApi
import com.example.data.remote.datasource.declaration.RemoteFriendDataSource
import com.example.data.remote.response.friend.FriendListResponse
import com.example.data.remote.response.friend.RequestListResponse
import io.reactivex.Completable
import io.reactivex.Single

class RemoteFriendDataSourceImpl(
    private val friendApi: FriendApi
): RemoteFriendDataSource {

    override fun addFriend(friend_id: String): Single<Completable> =
        friendApi.addFriend(
            accessToken = ACCESS_TOKEN,
            friend_id = friend_id
        )

    override fun fetchFriendList(): Single<FriendListResponse> =
        friendApi.fetchFriendList(accessToken = ACCESS_TOKEN)

    override fun searchFriend(name: String): Single<Completable> =
        friendApi.searchFriend(accessToken = ACCESS_TOKEN, name)

    override fun receiveFriend(sender_id: String): Single<Completable> =
        friendApi.receiveFriend(accessToken = ACCESS_TOKEN, sender_id)

    override fun refuseFriend(sender_id: String): Single<Completable> =
        friendApi.refuseFriend(accessToken = ACCESS_TOKEN, sender_id)

    override fun requestList(): Single<RequestListResponse> =
        friendApi.fetchRequestList(accessToken = ACCESS_TOKEN)
}
