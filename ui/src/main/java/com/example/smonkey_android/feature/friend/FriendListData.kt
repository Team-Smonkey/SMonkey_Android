package com.example.smonkey_android.feature.friend

import com.example.data.domain.enums.ColorType
import com.example.data.remote.response.friend.FriendListResponse
import com.google.gson.annotations.SerializedName

data class FriendListData(
    val content: Content
) {
    data class Content(
        val friendList: List<FriendList>
    )

    data class FriendList(
        val friendId: Long,
        val userName: String,
        val smonkeyName: String,
        val backgroundColor: String,
        val step: Int,
        val point: Int,
        val level: Int,
        val nextPoint: Int,
    )
}

fun FriendListResponse.FriendList.toRv() =
    FriendListData.FriendList(
        friendId = friendId,
        userName = userName,
        smonkeyName = smonkeyName,
        backgroundColor = backgroundColor,
        step = step,
        point = point,
        level = level,
        nextPoint = nextPoint
    )