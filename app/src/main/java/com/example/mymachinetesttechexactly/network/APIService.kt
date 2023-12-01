package com.example.mymachinetesttechexactly.network

import com.example.mymachinetesttechexactly.data.dto.AppResponse
import com.example.mymachinetesttechexactly.utils.network.ApiEndPoint
import retrofit2.http.*

interface APIService {

    @Headers("Content-Type: application/json")
    @POST(ApiEndPoint.apiAppList)
    suspend fun getAppsList(
        @Query("kid_id") kid_id: Int,
    ): AppResponse
}