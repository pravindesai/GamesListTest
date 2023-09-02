package com.realy.vasundharainfotechtest.data.network

import com.realy.vasundharainfotechtest.data.model.ObjNetworkResponse
import retrofit2.http.GET

interface RestService {
    @GET("17/com.hd.camera.apps.high.quality")
    suspend fun getAllApps():ObjNetworkResponse?
}

