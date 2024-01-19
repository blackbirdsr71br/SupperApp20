package com.alex.dashboarddemo.data.repository

import android.util.Log
import com.alex.dashboarddemo.data.remote.Result.Success
import com.alex.dashboarddemo.domain.model.GSDADashboard
import com.alex.dashboarddemo.utils.GSDAFirebaseController
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GSDAFirebaseRepository @Inject constructor(
    private val firebase: GSDAFirebaseController,
) {
    fun getConfig(key: String): Flow<com.alex.dashboarddemo.data.remote.Result<GSDADashboard>> = flow {
        val result = firebase.getRemoteInstance().getString(key)
        Log.i("firebase", "value: $result")
        if (result.isNotEmpty()) {
            val data = try {
                Gson().fromJson(result, GSDADashboard::class.java)
            } catch (e: Exception) {
                GSDADashboard(data = emptyList())
            }
            emit(Success(data))
        } else {
            firebase.getRemoteInstance().fetchAndActivate()
            // TO DO call mock data
            emit(Success(GSDADashboard(data = emptyList())))
        }
    }
}
