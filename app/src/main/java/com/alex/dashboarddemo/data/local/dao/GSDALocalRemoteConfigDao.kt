package com.alex.dashboarddemo.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.alex.dashboarddemo.domain.entity.GSDALocalRemoteConfig

@Dao
interface GSDALocalRemoteConfigDao : GSDABaseDao<GSDALocalRemoteConfig> {
    @Query("SELECT * FROM gsda_remote_config_table WHERE id = :key")
    suspend fun getRemoteConfig(key: String): GSDALocalRemoteConfig?
}
