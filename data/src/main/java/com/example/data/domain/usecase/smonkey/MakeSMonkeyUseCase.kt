package com.example.data.domain.usecase.smonkey

import com.example.data.domain.usecase.UseCase
import com.example.data.remote.datasource.declaration.RemoteSMonkeyDataSource
import com.example.data.remote.request.smonkey.MakeSMonkeyRequest
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

class MakeSMonkeyUseCase(
    private val remoteSMonkeyDataSource: RemoteSMonkeyDataSource,
    disposable: CompositeDisposable
) : UseCase<MakeSMonkeyRequest, Completable>(disposable) {
    override fun buildUseCase(data: MakeSMonkeyRequest): Single<Completable> =
        remoteSMonkeyDataSource.makeSMonkey(data)
}
