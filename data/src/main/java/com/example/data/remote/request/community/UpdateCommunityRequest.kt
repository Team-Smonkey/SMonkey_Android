package com.example.data.remote.request.community

data class UpdateCommunityRequest(
    val title: String,
    val content: String,
    val category: String,
)
