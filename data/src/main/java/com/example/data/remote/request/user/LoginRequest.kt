package com.example.data.remote.request.user

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("account_id") val accountId: String,
    @SerializedName("password") val password: String,
)
