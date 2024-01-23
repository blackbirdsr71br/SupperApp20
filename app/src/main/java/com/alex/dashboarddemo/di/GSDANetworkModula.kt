package com.alex.dashboarddemo.di

import com.alex.dashboarddemo.data.remote.GSDAApiService
import com.alex.dashboarddemo.data.repository.GSDARemoteDataSourceImpl
import com.alex.dashboarddemo.domain.repository.GSDARemoteDataSource
import com.alex.dashboarddemo.utils.GSDAConstants.BASE_URL
import com.alex.dashboarddemo.utils.GSDAFirebaseController
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object GSDANetworkModula {

    @Provides
    @Singleton
    fun gsdaProvidesHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addNetworkInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun gsdaProvidesRetrofitInstance(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun gsdaProvidesDashBoarApi(retrofit: Retrofit): GSDAApiService {
        return retrofit.create(GSDAApiService::class.java)
    }

    @Provides
    @Singleton
    fun gsdaProvidesRemoteDataSource(
        dashboardApi: GSDAApiService,
        firebase: GSDAFirebaseController,
    ): GSDARemoteDataSource {
        return GSDARemoteDataSourceImpl(
            dashboardApi = dashboardApi,
            firebase = firebase,
        )
    }

    @Provides
    @Singleton
    fun provideFirebaseController(): GSDAFirebaseController {
        return GSDAFirebaseController()
    }
}
