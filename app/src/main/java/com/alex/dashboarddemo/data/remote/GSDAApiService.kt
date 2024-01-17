package com.alex.dashboarddemo.data.remote

import com.alex.dashboarddemo.domain.model.GSDADashboard
import com.alex.dashboarddemo.utils.GSDAConstants.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface GSDAApiService {
    @GET("dashbaz")
    suspend fun getDashboard(): GSDADashboard

    @GET("dashbaz_random")
    suspend fun getRandomDashboard(): GSDADashboard
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

    val service: GSDAApiService by lazy {
        retrofit.baseUrl(BASE_URL)
            .build().create(GSDAApiService::class.java)
    }
}
