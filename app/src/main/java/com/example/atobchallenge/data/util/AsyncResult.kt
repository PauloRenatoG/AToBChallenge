package com.example.atobchallenge.data.util

sealed class AsyncResult<out T> {
    data class Success<T>(val data: T?) : AsyncResult<T>()
    data class Error(val message: String?): AsyncResult<Nothing>()
}
