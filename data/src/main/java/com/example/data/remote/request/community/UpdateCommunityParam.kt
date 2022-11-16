package com.example.data.remote.request.community

data class UpdateCommunityRequest(
    val feed_id: Int,
    val title: String,
    val content: String,
    val category: String,
)
