package e.erga.forecastmvvm.data.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import e.erga.forecastmvvm.data.CurrentWeatherResponse
import e.erga.forecastmvvm.internal.NoConnectivityException

class WeatherNetworkDataSourceImpl(
        private val apixuWeatherService: ApixuWeatherApiService
    ) : WeatherNetworkDataSource {

        private val _downloadedCurrentWeather = MutableLiveData<CurrentWeatherResponse>()

            override val downloadCurrentWeather: LiveData<CurrentWeatherResponse>
            get() = _downloadedCurrentWeather

        override suspend fun fetchCurrentWeather(location: String) {
            try {
                val fetchedCurrentWeather = apixuWeatherService
                    .getCurrentWeatherAsync(location)
                    .await()

                _downloadedCurrentWeather.postValue(fetchedCurrentWeather)
            }
            catch (e: NoConnectivityException){
                Log.e("Connectivity", "No Internet Connection", e )
            }
        }
    }