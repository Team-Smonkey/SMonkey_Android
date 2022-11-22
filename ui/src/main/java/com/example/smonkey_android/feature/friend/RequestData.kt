package com.example.smonkey_android.feature.friend

import com.example.data.remote.response.friend.RequestListResponse

data class RequestData(
    val friendId: Long,
    val userName: String,
    val smonkeyName: String,
    val backgroundColor: String,
    val step: Int,
    val point: Int,
    val level: Int,
    val nextPoint: Int,
)

fun RequestListResponse.FriendList.toRv() =
    RequestData(
        friendId = friendId,
        userName = userName,
        smonkeyName = smonkeyName,
        backgroundColor = backgroundColor,
        step = step,
        point = point,
        level = level,
        nextPoint = nextPoint,
    )