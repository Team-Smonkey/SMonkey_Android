package com.example.data.remote.response.community

import com.google.gson.annotations.SerializedName

data class FetchCommunityDetailResponse(
    @SerializedName("writer") val writer: Writer,
    @SerializedName("feed") val feed: Feed,
) {

    data class Writer(
        @SerializedName("name") val name: String,
        @SerializedName("smonkey") val sMonkey: SMonkey,
    ) {
        data class SMonkey(
            @SerializedName("name") val sMonkeyName: String,
            @SerializedName("image_url") val imageUrl: String,
        )
    }

    data class Feed(
        @SerializedName("feed_id") val feedId: Int,
        @SerializedName("title") val title: String,
        @SerializedName("content") val content: String,
        @SerializedName("createAt") val createAt: String,
        @SerializedName("like") val like: Int,
        @SerializedName("isLike") val isLike: Boolean,
        @SerializedName("comment") val comment: List<Comment>,
    ) {
        data class Comment(
            @SerializedName("profileImg") val profileImage: String,
            @SerializedName("name") val commenterName: String,
            @SerializedName("writeAt") val writeAt: String,
            @SerializedName("content") val commentContent: String,
        )
    }
}
