package com.realy.vasundharainfotechtest.data.repository

import com.realy.vasundharainfotechtest.data.model.ObjNetworkResponse
import com.realy.vasundharainfotechtest.data.network.RestService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class AppDetailsRepository(){
    private val BASE_URL = "http://vasundharaapps.com/artwork_apps/api/AdvertiseNewApplications/"
    private val restService: RestService
    private val interceptor: HttpLoggingInterceptor
    private val client: OkHttpClient
    private val retrofit: Retrofit
    init {
        interceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT)
        interceptor.level = HttpLoggingInterceptor.Level.BASIC
        client = OkHttpClient.Builder().addInterceptor(interceptor)
            .readTimeout(10, TimeUnit.SECONDS)
            .build()

        retrofit   = Retrofit.Builder().baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        restService = retrofit.create(RestService::class.java)
    }

    suspend fun getAllAppsData(): Flow<ObjNetworkResponse?> {
        return flow{
            val result = restService.getAllApps()
            emit(result)
        }.flowOn(Dispatchers.IO)
    }


}