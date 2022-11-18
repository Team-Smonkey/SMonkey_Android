package com.example.data.remote.datasource.implementation

import com.example.data.domain.token.ACCESS_TOKEN
import com.example.data.remote.api.SMonkeyApi
import com.example.data.remote.datasource.declaration.RemoteSMonkeyDataSource
import com.example.data.remote.request.smonkey.MakeSMonkeyRequest
import com.example.data.remote.response.smonkey.SearchSMonkeyResponse
import io.reactivex.Completable
import io.reactivex.Single

class RemoteSMonkeyDataSourceImpl(
    private val sMonkeyApi: SMonkeyApi
): RemoteSMonkeyDataSource {
    override fun makeSMonkey(makeSMonkeyRequest: MakeSMonkeyRequest): Single<Completable> =
        sMonkeyApi.makeSMonkey(makeSMonkeyRequest)


    override fun alterSMonkeyColor(color: String): Single<Completable> =
        sMonkeyApi.alterSMonkeyColor(
            accessToken = ACCESS_TOKEN,
            color = color
        )

    override fun searchSMonkey(): Single<SearchSMonkeyResponse> =
        sMonkeyApi.searchSMonkey(ACCESS_TOKEN)
}
