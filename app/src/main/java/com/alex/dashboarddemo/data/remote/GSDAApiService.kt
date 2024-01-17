package com.alex.dashboarddemo.data.remote

import com.alex.dashboarddemo.domain.model.GSDADashboard
import retrofit2.http.GET

interface GSDAApiService {
    @GET("dashbaz")
    suspend fun getDashboard(): GSDADashboard

    @GET("dashbaz_random")
    suspend fun getRandomDashboard(): GSDADashboard
}
