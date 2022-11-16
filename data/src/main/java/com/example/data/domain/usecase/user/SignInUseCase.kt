package com.example.data.domain.usecase.user

import com.example.data.domain.usecase.UseCase
import com.example.data.remote.datasource.declaration.RemoteSMonkeyDataSource
import com.example.data.remote.datasource.declaration.RemoteUserDataSource
import com.example.data.remote.request.smonkey.MakeSMonkeyRequest
import com.example.data.remote.request.user.LoginRequest
import com.example.data.remote.response.LoginResponse
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

class SignInUseCase(
    private val remoteUserDataSource: RemoteUserDataSource,
    disposable: CompositeDisposable
) : UseCase<LoginRequest, LoginResponse>(disposable) {
    override fun buildUseCase(data: LoginRequest): Single<LoginResponse> =
        remoteUserDataSource.signIn(data)
}