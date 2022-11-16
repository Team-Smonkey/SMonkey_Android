package com.example.data.remote.datasource.implementation

import com.example.data.remote.api.UserApi
import com.example.data.remote.datasource.declaration.RemoteUserDataSource
import com.example.data.remote.request.user.LoginRequest
import com.example.data.remote.response.LoginResponse
import io.reactivex.Single

class RemoteUserDataSourceImpl(
    private val userApi: UserApi
): RemoteUserDataSource {

    override fun signIn(loginRequest: LoginRequest): Single<LoginResponse> =
        userApi.signIn(loginRequest)
}