package com.example.smonkey_android.feature.community

data class CommunityData(
    val profileImage: String,
    val name: String,
    val title: String,
    val content: String,
    val myHeart: Boolean,
    val heartCount: Int,
    val commentCount: Int,
    val localDataTime: String,
)
