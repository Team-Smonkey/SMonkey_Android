package com.example.data.remote.datasource.declaration

import com.example.data.remote.request.user.LoginRequest
import com.example.data.remote.response.LoginResponse
import io.reactivex.Single

interface RemoteUserDataSource {

    fun signIn(loginRequest: LoginRequest): Single<LoginResponse>
}