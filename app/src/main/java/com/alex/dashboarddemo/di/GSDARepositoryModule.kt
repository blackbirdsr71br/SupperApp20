package com.alex.dashboarddemo.di

import com.alex.dashboarddemo.data.repository.GSDADashboardRepository
import com.alex.dashboarddemo.domain.use_cases.GSDAUseCases
import com.alex.dashboarddemo.domain.use_cases.remote_config.GSDAConfigUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object GSDARepositoryModule {

    @Provides
    @Singleton
    fun gsdaProvidesUseCases(repository: GSDADashboardRepository): GSDAUseCases {
        return GSDAUseCases(
            getRemoteConfigUseCase = GSDAConfigUseCase(repository),
        )
    }
}
