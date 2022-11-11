package com.example.data.remote.request.community

data class CreateCommunityRequest(
    val title: String,
    val content: String,
    val category: String,
)
