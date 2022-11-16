package com.example.data.util

sealed class Error {
    object NetworkException : Error()

    object BadRequestException : Error()

    object UnAuthorizedException : Error()

    object ForbiddenException : Error()

    object NotFoundException : Error()

    object TimeoutException : Error()

    object ConflictException : Error()

    object InternalServerException : Error()

    object UnknownException : Error()

    object LockedException : Error()
}