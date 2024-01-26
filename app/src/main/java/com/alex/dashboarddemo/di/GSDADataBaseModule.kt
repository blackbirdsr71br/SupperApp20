package com.alex.dashboarddemo.di

import android.content.Context
import androidx.room.Room
import com.alex.dashboarddemo.data.local.GSDARemoteConfigDB
import com.alex.dashboarddemo.data.local.dao.GSDALocalRemoteConfigDao
import com.alex.dashboarddemo.data.repository.GSDALocalDataSourceImpl
import com.alex.dashboarddemo.domain.repository.GSDALocalDataSource
import com.alex.dashboarddemo.utils.GSDAConstants.DASHBOARD_DATABASE
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object GSDADataBaseModule {
    @Provides
    @Singleton
    fun gsdaProvidesRemoteConfigDB(
        @ApplicationContext mContext: Context,
    ): GSDARemoteConfigDB {
        return Room.databaseBuilder(
            mContext,
            GSDARemoteConfigDB::class.java,
            DASHBOARD_DATABASE,
        ).build()
    }

    @Singleton
    @Provides
    fun provideGSDARemoteConfigDao(
        db: GSDARemoteConfigDB,
    ): GSDALocalRemoteConfigDao {
        return db.remoteConfigDao()
    }

    @Provides
    @Singleton
    fun gsdaProvidesLocalRemoteConfig(
        remoteConfigDao: GSDALocalRemoteConfigDao,
        moshiInit: Moshi,
    ): GSDALocalDataSource {
        return GSDALocalDataSourceImpl(
            remoteConfigDao = remoteConfigDao,
            moshiInit = moshiInit,
        )
    }
}
