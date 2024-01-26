package com.alex.dashboarddemo.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.alex.dashboarddemo.utils.GSDAConstants.DASHBOARD_DATABASE_REMOTE_CONFIG_TABLE

@Entity(tableName = DASHBOARD_DATABASE_REMOTE_CONFIG_TABLE)
data class GSDARemoteConfig(
    @PrimaryKey
    val id: String = "",
    val data: String = "",
    val timeStamp: Long = 0L,
)
