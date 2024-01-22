package com.alex.dashboarddemo.data.remote

sealed class GSDAResult<out T> {
    object Loading : GSDAResult<Nothing>()
    class Success<T>(val data: T?) : GSDAResult<T>()
    class Failure(val error: Throwable) : GSDAResult<Nothing>()
}
