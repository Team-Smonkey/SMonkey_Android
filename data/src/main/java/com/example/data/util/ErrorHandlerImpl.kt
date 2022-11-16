package com.example.data.util

import retrofit2.HttpException
import java.io.IOException

class ErrorHandlerImpl : ErrorHandler {
    override fun getError(throwable: Throwable): Error {
        return when (throwable) {
            is IOException -> Error.NetworkException
            is HttpException -> {
                when (throwable.code()) {
                    400 -> Error.BadRequestException
                    401 -> Error.UnAuthorizedException
                    403 -> Error.ForbiddenException
                    404 -> Error.NotFoundException
                    408 -> Error.TimeoutException
                    409 -> Error.ConflictException
                    423 -> Error.LockedException
                    500 -> Error.InternalServerException

                    else -> Error.UnknownException
                }
            }
            else -> Error.UnknownException
        }
    }
}