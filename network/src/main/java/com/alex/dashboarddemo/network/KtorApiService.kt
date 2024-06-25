package com.alex.dashboarddemo.network

import com.alex.dashboarddemo.network.model.Dashboard
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.get
import io.ktor.serialization.gson.gson
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.http.GET

const val BASE_URL = "http://demo5027027.mockable.io/"

interface KtorApiService {
    @GET("serverui")
    suspend fun getDashboard(): Dashboard
}

// creates Ktor client with OkHttp engine
val ktor =
    HttpClient(OkHttp) {
        // default validation to throw exceptions for non-2xx responses
        expectSuccess = true

        engine {
            // add logging interceptor
            addInterceptor(
                HttpLoggingInterceptor().apply {
                    setLevel(
                        HttpLoggingInterceptor.Level.BODY,
                    )
                },
            )
        }

        // set default request parameters
        defaultRequest {
            // add base url for all request
            url(BASE_URL)
        }

        // use gson content negotiation for serialize or deserialize
        install(ContentNegotiation) {
            gson()
        }
    }

// Ktor create a service
val ktorService: KtorApiService = UserApiServiceImpl(ktor)

class UserApiServiceImpl(private val ktor: HttpClient) : KtorApiService {
    override suspend fun getDashboard(): Dashboard {
        return ktor.get("/dashbaz").body<Dashboard>()
    }
}
