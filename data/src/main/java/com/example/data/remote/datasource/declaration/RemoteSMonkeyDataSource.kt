package com.example.data.remote.datasource.declaration

import com.example.data.remote.request.smonkey.MakeSMonkeyRequest
import com.example.data.remote.response.smonkey.SearchSMonkeyResponse
import io.reactivex.Completable
import io.reactivex.Single

interface RemoteSMonkeyDataSource {

    fun makeSMonkey(makeSMonkeyRequest: MakeSMonkeyRequest):Single<Completable>

    fun alterSMonkeyColor(color: String): Single<Completable>

    fun searchSMonkey(): Single<SearchSMonkeyResponse>
}
