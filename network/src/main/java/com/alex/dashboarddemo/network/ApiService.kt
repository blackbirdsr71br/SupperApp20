package com.alex.dashboarddemo.network

import com.alex.dashboarddemo.network.model.Dashboard
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("serverdriven")
    suspend fun getDashboard(): Dashboard

    @GET("serverdriven")
    suspend fun getRandomDashboard(): Dashboard
}

object NetworkClient {
    private val okHttpClient =
        OkHttpClient.Builder()
            .addNetworkInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()

    private val retrofit =
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient)

    val service: ApiService by lazy {
        retrofit.baseUrl("http://demo5027027.mockable.io/")
            .build().create(ApiService::class.java)
    }
}
