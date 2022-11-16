package com.example.data.util

interface ErrorHandler {
    fun getError(throwable: Throwable) : Error
}