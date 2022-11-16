package com.example.data.util

import io.reactivex.Completable
import io.reactivex.Single

sealed class Result<T> {
    data class Success<T>(val value: T) : Result<T>()

    data class Failure<T>(val reason: Error) : Result<T>()
}

fun Completable.toSingleResult(
    handler: ErrorHandler
): Single<Result<Unit>> = this
    .toSingle {
    }.toResult(handler)

fun <T> Single<T>.toResult(
    handler: ErrorHandler
): Single<Result<T>> = this
    .map {
        Result.Success(it) as Result<T>
    }
    .onErrorReturn {
        Result.Failure(handler.getError(it))
    }

