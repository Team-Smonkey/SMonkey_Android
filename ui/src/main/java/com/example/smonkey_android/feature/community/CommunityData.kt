package com.example.smonkey_android.feature.community

import com.example.data.domain.enums.CategoryType
import com.example.data.remote.response.community.FetchCommunityResponse
import com.google.gson.annotations.SerializedName

data class CommunityData(
    val content: Content,
) {
    data class Content(
        val feedList: List<FeedList>
    ) {
        data class FeedList(
            val writer: Writer,
            val feedId: Int,
            val title: String,
            val likeCount: Int,
            val isLike: Boolean,
            val content: String,
            val categoryType: CategoryType,
            val createAt: String,
        ) {
            data class Writer(
                val userName: String,
                val sMonkeyName: String,
                val backgroundColor: String,
                val step: Int,
                val point: Int,
                val level: Int,
                val nextPoint: Int,
            )
        }
    }
}

fun FetchCommunityResponse.Content.FeedList.Writer.toRv() =
    CommunityData.Content.FeedList.Writer(
        userName = userName,
        sMonkeyName = sMonkeyName,
        backgroundColor = backgroundColor,
        step = step,
        point = point,
        level = level,
        nextPoint = nextPoint,
    )

fun FetchCommunityResponse.Content.FeedList.toRv() =
    CommunityData.Content.FeedList(
        writer = writer.toRv(),
        feedId = feedId,
        title = title,
        likeCount = likeCount,
        isLike = isLike,
        content = content,
        categoryType = categoryType,
        createAt = createAt,
    )

fun FetchCommunityResponse.Content.toRv() =
    CommunityData.Content(
        feedList = feedList.map { it.toRv() }
    )

fun FetchCommunityResponse.toRv() =
    CommunityData(
        content = content.toRv()
    )
