package com.example.data.remote.response.community

import com.google.gson.annotations.SerializedName

data class FetchCommunityResponse(
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
        @SerializedName("comment") val comment: Int,
    )
}
