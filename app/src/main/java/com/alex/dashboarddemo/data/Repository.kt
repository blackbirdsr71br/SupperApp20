package com.alex.dashboarddemo.data

import com.alex.dashboarddemo.network.NetworkClient
import com.alex.dashboarddemo.network.ktorService
import com.alex.dashboarddemo.network.model.Dashboard
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import java.lang.Exception

object Repository {

    private val apiService = NetworkClient.service
    private val ktorApiService = ktorService

    suspend fun getDashboardData(isRandomRequired : Boolean = false) : Flow<Result<List<Dashboard.Item>>> {
        return withContext(Dispatchers.IO) {
            flow {
                try {
                    if (isRandomRequired) {
                        emit(Result.Success(apiService.getRandomDashboard().data))
                    } else {
                        emit(Result.Success(apiService.getDashboard().data))
                    }
                } catch (exception : Exception) {
                    emit(Result.Failure(exception))
                }
            }
        }
    }

    suspend fun getKDashboardData() : Flow<Result<List<Dashboard.Item>>> {
        return withContext(Dispatchers.IO) {
            flow {
                try {
                    emit(Result.Success(ktorApiService.getDashboard().data))
                } catch (exception : Exception) {
                    emit(Result.Failure(exception))
                }
            }
        }
    }
}
