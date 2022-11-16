package com.example.data.remote.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("content") val content: Content
) {
    data class Content(
        @SerializedName("access_token") val accessToken: String,
        @SerializedName("refresh_token") val refreshToken: String,
    )
}
