package com.example.data.remote.response.friend

import com.google.gson.annotations.SerializedName

data class SearchFriendResponse(
    @SerializedName("friends") val friends: Friends
) {
    data class Friends(
        @SerializedName("friend_id") val friendId: String,
        @SerializedName("name") val name: String,
        @SerializedName("smonkey") val smonkey: SMonkey
    ) {
        data class SMonkey(
            @SerializedName("image_url") val imageUrl: String,
            @SerializedName("background_color") val backGroundColor: String,
            @SerializedName("name") val name: String,
            @SerializedName("step") val step: Int,
        )
    }
}
