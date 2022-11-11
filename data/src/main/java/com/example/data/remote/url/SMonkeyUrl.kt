package com.example.data.remote.url

object SMonkeyUrl {

    const val SMonkey = "/smonkey"
    const val Community = "/feed"

    object SMonkeies {
        const val SMonkeyColor = "/smonkey/color"
        const val searchSMonkey = "/smonkey/{user-id}"
    }

    object Communities {
        const val CommunityDetail = "/feed/{feed-id}"
        const val CommunityLike = "${CommunityDetail}/like"
    }
}