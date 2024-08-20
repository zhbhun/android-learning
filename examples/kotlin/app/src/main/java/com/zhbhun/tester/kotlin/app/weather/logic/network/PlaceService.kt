package com.zhbhun.tester.kotlin.app.weather.logic.network

import com.zhbhun.tester.kotlin.BuildConfig
import com.zhbhun.tester.kotlin.app.weather.logic.model.PlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PlaceService {

    @GET("v2/place?token=${BuildConfig.CAIYUN_TOKEN}&lang=zh_CN")
    fun searchPlaces(@Query("query") query: String): Call<PlaceResponse>
}
