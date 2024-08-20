package com.zhbhun.tester.kotlin.app.weather.logic.network

import com.zhbhun.tester.kotlin.BuildConfig
import com.zhbhun.tester.kotlin.app.weather.logic.model.DailyResponse
import com.zhbhun.tester.kotlin.app.weather.logic.model.RealtimeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface WeatherService {

    @GET("v2.5/${BuildConfig.CAIYUN_TOKEN}/{lng},{lat}/realtime.json")
    fun getRealtimeWeather(
        @Path("lng") lng: String,
        @Path("lat") lat: String
    ): Call<RealtimeResponse>

    @GET("v2.5/${BuildConfig.CAIYUN_TOKEN}/{lng},{lat}/daily.json")
    fun getDailyWeather(@Path("lng") lng: String, @Path("lat") lat: String): Call<DailyResponse>

}
