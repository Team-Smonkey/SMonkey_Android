package com.example.data.remote.api

import com.example.data.remote.request.user.LoginRequest
import com.example.data.remote.response.LoginResponse
import com.example.data.remote.url.SMonkeyUrl
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {

    @POST(SMonkeyUrl.Login)
    fun signIn(
        @Body loginRequest: LoginRequest
    ): Single<LoginResponse>
}
