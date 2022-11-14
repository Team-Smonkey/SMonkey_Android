package com.example.data.domain.usecase.smonkey

import com.example.data.domain.usecase.UseCase
import com.example.data.remote.datasource.declaration.RemoteSMonkeyDataSource
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

class AlterSMonkeyColorUseCase(
    private val remoteSMonkeyDataSource: RemoteSMonkeyDataSource,
    disposable: CompositeDisposable
) : UseCase<String, Completable>(disposable) {
    override fun buildUseCase(data: String): Single<Completable> =
        remoteSMonkeyDataSource.alterSMonkeyColor(data)
}
