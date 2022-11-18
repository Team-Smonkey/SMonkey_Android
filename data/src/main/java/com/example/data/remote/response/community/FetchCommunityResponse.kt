package com.example.data.remote.response.community

import com.example.data.domain.enums.CategoryType
import com.example.data.domain.enums.ColorType
import com.google.gson.annotations.SerializedName

data class FetchCommunityResponse(
    @SerializedName("content") val content: Content,
) {
    data class Content(
        @SerializedName("feed_list") val feedList: List<FeedList>
    ) {
        data class FeedList(
            @SerializedName("writer") val writer: Writer,
            @SerializedName("feed_id") val feedId: Int,
            @SerializedName("title") val title: String,
            @SerializedName("like_count") val likeCount: Int,
            @SerializedName("is_like") val isLike: Boolean,
            @SerializedName("content") val content: String,
            @SerializedName("category") val categoryType: CategoryType,
            @SerializedName("created_at") val createAt: String,
        ) {
            data class Writer(
                @SerializedName("user_name") val userName: String,
                @SerializedName("smonkey_name") val sMonkeyName: String,
                @SerializedName("background_color") val backgroundColor: ColorType,
                @SerializedName("step") val step: Int,
                @SerializedName("point") val point: Int,
                @SerializedName("level") val level: Int,
                @SerializedName("next_point") val nextPoint: Int,
            )
        }
    }
}
