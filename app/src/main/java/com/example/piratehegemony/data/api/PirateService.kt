package com.example.piratehegemony.data.api

import com.example.piratehegemony.data.model.PirateInfo
import com.example.piratehegemony.data.model.PirateResponse
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PirateService {

    @GET("pokemon")
    suspend fun fetchPirateList(
        @Query("limit") limit: Int = 10,
        @Query("offset") offset: Int = 0
    ): ApiResponse<PirateResponse>

    @GET("pokemon/{id}")
    suspend fun fetchPirateInfo(
        @Path("id") id: Int
    ): ApiResponse<PirateInfo>

}