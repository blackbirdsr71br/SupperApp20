package com.alex.dashboarddemo.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alex.dashboarddemo.data.local.dao.GSDALocalRemoteConfigDao
import com.alex.dashboarddemo.domain.entity.GSDARemoteConfig

@Database(
    entities = [GSDARemoteConfig::class],
    version = 1,
    exportSchema = false,
)
abstract class GSDARemoteConfigDB : RoomDatabase() {
    abstract fun remoteConfigDao(): GSDALocalRemoteConfigDao
}
