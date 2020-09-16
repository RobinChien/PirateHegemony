package com.example.piratehegemony.utils

import com.example.piratehegemony.data.api.HttpRequestInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object NetworkManager {
    fun provideOkHttpClient(): OkHttpClient {
        val httpRequestInterceptor: HttpRequestInterceptor = HttpRequestInterceptor()
        return OkHttpClient.Builder()
            .addInterceptor(httpRequestInterceptor)
            .build()
    }

    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
}