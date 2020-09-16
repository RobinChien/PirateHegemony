package com.example.piratehegemony.data.api

import com.example.piratehegemony.data.model.PirateResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PirateService {

    @GET("pokemon")
    fun fetchPirateList(
        @Query("limit") limit: Int = 10,
        @Query("offset") offset: Int = 0
    ): Call<PirateResponse>

}