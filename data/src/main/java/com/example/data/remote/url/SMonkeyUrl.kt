package com.example.data.remote.url

object SMonkeyUrl {

    const val SMonkey = "/smonkey"
    const val Community = "/feed"
    const val Friends = "/friend"
    const val User = "/user"
    const val Login = "/user/signIn"

    object SMonkeies {
        const val SMonkeyColor = "/smonkey/color"
        const val searchSMonkey = "/smonkey/{user-id}"
    }

    object Communities {
        const val CommunityDetail = "/feed/{feed-id}"
        const val CommunityLike = "${CommunityDetail}/like"
    }

    object Friend {
        const val PathFriend = "${Friends}/{friend-id}"
        const val FetchFriend = "${Friends}/search"
        const val ReceiveFriendRequest = "${Friends}/accept"
        const val RefuseFriendRequest = "${Friends}/refuse"
        const val RequestList = "${Friends}/request"
    }
}