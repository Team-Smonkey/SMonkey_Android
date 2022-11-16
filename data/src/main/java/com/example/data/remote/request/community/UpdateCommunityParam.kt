package com.example.data.remote.request.community

data class UpdateCommunityParam(
    val feed_id: Int,
    val title: String,
    val content: String,
    val category: String,
)
