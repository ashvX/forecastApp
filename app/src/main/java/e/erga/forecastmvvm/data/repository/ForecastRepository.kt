package e.erga.forecastmvvm.data.repository

import androidx.lifecycle.LiveData
import e.erga.forecastmvvm.data.db.unitilocalized.UnitSpecificCurrentWeatherEntry


interface ForecastRepository {
    suspend fun getCurrentWeather(metric: Boolean): LiveData<out UnitSpecificCurrentWeatherEntry>
}