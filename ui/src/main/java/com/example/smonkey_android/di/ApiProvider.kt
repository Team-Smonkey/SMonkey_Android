package com.example.smonkey_android.di

import com.example.data.remote.api.CommunityApi
import com.example.data.remote.api.FriendApi
import com.example.data.remote.api.SMonkeyApi
import com.example.data.remote.api.UserApi
import retrofit2.Retrofit
import retrofit2.create

fun provideCommunityApi(retrofit: Retrofit): CommunityApi =
    retrofit.create(CommunityApi::class.java)

fun provideFriendApi(retrofit: Retrofit): FriendApi =
    retrofit.create(FriendApi::class.java)

fun provideSMonkeyApi(retrofit: Retrofit): SMonkeyApi =
    retrofit.create(SMonkeyApi::class.java)

fun provideUserApi(retrofit: Retrofit): UserApi =
    retrofit.create(UserApi::class.java)
