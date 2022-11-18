package com.example.data.remote.api

import com.example.data.remote.request.smonkey.MakeSMonkeyRequest
import com.example.data.remote.response.smonkey.SearchSMonkeyResponse
import com.example.data.remote.url.SMonkeyUrl
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface SMonkeyApi {

    @POST(SMonkeyUrl.SMonkey)
    fun makeSMonkey(
        @Body makeSMonkeyRequest: MakeSMonkeyRequest
    ): Single<Completable>

    @POST(SMonkeyUrl.SMonkeies.SMonkeyColor)
    fun alterSMonkeyColor(
        @Header ("Authorization") accessToken: String,
        @Body color: String,
    ): Single<Completable>

    @GET(SMonkeyUrl.SMonkey)
    fun searchSMonkey(
        @Header("Authorization") accessToken: String,
    ): Single<SearchSMonkeyResponse>
}
