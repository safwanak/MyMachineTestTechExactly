package com.example.mymachinetesttechexactly.repository

import com.example.mymachinetesttechexactly.network.Resource
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import timber.log.Timber

abstract class BaseRepository {
    suspend fun <T> safeApiCall(apiCall: suspend () -> T): Resource<T> {
        return withContext(Dispatchers.IO) {
            try {
                Resource.Success(apiCall.invoke())
            } catch (throwable: Throwable) {
                val error = Gson().toJson(throwable)
                when (throwable) {
                    is HttpException -> {
                        val code = throwable.code()
                        Timber.e("OkHttpClient Error ->$error ")
                        Resource.Failure(false, throwable.code(), throwable.response()?.errorBody())
                    }

                    else -> {
                        Timber.e("OkHttpClient Error -> $error")
                        Resource.Failure(true, null, null)
                    }
                }
            }
        }
    }

}