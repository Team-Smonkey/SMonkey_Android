package com.example.data.remote.response.friend

import com.google.gson.annotations.SerializedName

data class RequestListResponse(
    @SerializedName("content") val content: Content
) {
    data class Content(
        @SerializedName("friend_list") val friendList: List<FriendList>
    )

    data class FriendList(
        @SerializedName("friend_id") val friendId: Int,
        @SerializedName("user_name") val userName: String,
        @SerializedName("smonkey_name") val smonkeyName: String,
        @SerializedName("background_color") val backgroundColor: String,
        @SerializedName("step") val step: Int,
        @SerializedName("point") val point: Int,
        @SerializedName("level") val level: Int,
        @SerializedName("next_point") val nextPoint: Int,
    )
}
