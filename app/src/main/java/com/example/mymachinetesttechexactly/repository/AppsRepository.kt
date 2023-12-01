package com.example.mymachinetesttechexactly.repository

import com.example.mymachinetesttechexactly.network.APIService
import javax.inject.Inject

class AppsRepository @Inject constructor(private val apiService: APIService) :
    BaseRepository() {
    suspend fun getAppsList(kid_id: Int) = safeApiCall {
        apiService.getAppsList(kid_id)
    }
}