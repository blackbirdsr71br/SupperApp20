package com.alex.dashboarddemo.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.alex.dashboarddemo.domain.entity.GSDARemoteConfig

@Dao
interface GSDALocalRemoteConfigDao : GSDABaseDao<GSDARemoteConfig> {
    @Query("SELECT * FROM gsda_remote_config_table WHERE id = :key")
    suspend fun getRemoteConfig(key: String): GSDARemoteConfig

    @Query("DELETE FROM gsda_remote_config_table")
    suspend fun deleteRemoteConfig()
}
