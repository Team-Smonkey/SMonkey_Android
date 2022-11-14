package com.example.data.domain.usecase.smonkey

import com.example.data.domain.usecase.UseCase
import com.example.data.remote.datasource.declaration.RemoteSMonkeyDataSource
import com.example.data.remote.response.smonkey.SearchSMonkeyResponse
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

class SearchSMonkeyUseCase(
    private val remoteSMonkeyDataSource: RemoteSMonkeyDataSource,
    disposable: CompositeDisposable
) : UseCase<String, SearchSMonkeyResponse>(disposable) {
    override fun buildUseCase(data: String): Single<SearchSMonkeyResponse> =
        remoteSMonkeyDataSource.searchSMonkey(data)
}
