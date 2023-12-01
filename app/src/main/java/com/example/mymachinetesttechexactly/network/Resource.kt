package com.example.mymachinetesttechexactly.network

sealed class Resource<out T> {
    data class Success<T>(var value: T) : Resource<T>()

    data class Failure<E>(
        val isNetworkError: Boolean, val errorCode: Int?, val errorBody: E
    ) : Resource<Nothing>()
}