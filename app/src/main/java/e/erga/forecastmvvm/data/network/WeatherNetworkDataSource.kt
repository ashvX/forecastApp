package e.erga.forecastmvvm.data.network

import androidx.lifecycle.LiveData
import e.erga.forecastmvvm.data.CurrentWeatherResponse

interface WeatherNetworkDataSource {
    val downloadCurrentWeather : LiveData<CurrentWeatherResponse>

    suspend fun fetchCurrentWeather(
        location: String
    )
}