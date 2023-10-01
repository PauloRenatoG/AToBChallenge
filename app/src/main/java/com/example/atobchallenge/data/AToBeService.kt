package com.example.atobchallenge.data

import com.example.atobchallenge.data.model.DummyResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AToBeService {

    @GET("products")
    suspend fun getProductsList(
        @Query("limit") limit: Int = 0
    ): Response<DummyResponse>
}
