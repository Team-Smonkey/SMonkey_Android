package com.example.data.remote.response.smonkey

import com.google.gson.annotations.SerializedName

data class SearchSMonkeyResponse(
    @SerializedName("status") val status: Int,
    @SerializedName("content") val content: Content,
) {
    data class Content(
        @SerializedName("user_name") val userName: String,
        @SerializedName("smonkey_name") val sMonkeyName: String,
        @SerializedName("background_color") val backgroundColor: String,
        @SerializedName("step") val step: Int,
        @SerializedName("point") val point: Int,
        @SerializedName("level") val level: Int,
        @SerializedName("next_point") val  nextPoint: Int,
    )
}
