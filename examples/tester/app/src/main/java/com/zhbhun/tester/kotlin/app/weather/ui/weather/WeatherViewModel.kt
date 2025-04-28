package com.zhbhun.tester.kotlin.app.weather.ui.weather

import androidx.lifecycle.*
import com.zhbhun.tester.kotlin.app.weather.logic.Repository
import com.zhbhun.tester.kotlin.app.weather.logic.model.Location

class WeatherViewModel : ViewModel() {

    private val locationLiveData = MutableLiveData<Location>()

    var locationLng = ""

    var locationLat = ""

    var placeName = ""

    val weatherLiveData = locationLiveData.switchMap() { location ->
        Repository.refreshWeather(location.lng, location.lat, placeName)
    }

    fun refreshWeather(lng: String, lat: String) {
        locationLiveData.value = Location(lng, lat)
    }

}
