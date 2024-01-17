package com.alex.dashboarddemo.data

import com.alex.dashboarddemo.data.remote.NetworkClient
import com.alex.dashboarddemo.domain.model.GSDADashboard
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import java.lang.Exception

object Repository {

    private val apiService = NetworkClient.service

    suspend fun getDashboardData(isRandomRequired: Boolean = false): Flow<Result<List<GSDADashboard.Item>>> {
        return withContext(Dispatchers.IO) {
            flow {
                try {
                    if (isRandomRequired) {
                        emit(Result.Success(apiService.getRandomDashboard().data))
                    } else {
                        emit(Result.Success(apiService.getDashboard().data))
                    }
                } catch (exception: Exception) {
                    emit(Result.Failure(exception))
                }
            }
        }
    }
}
