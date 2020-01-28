package e.erga.forecastmvvm.data

import com.google.gson.annotations.SerializedName
import e.erga.forecastmvvm.data.db.entity.CurrentWeatherEntry
import e.erga.forecastmvvm.data.db.entity.Location
import e.erga.forecastmvvm.data.db.entity.Request


data class CurrentWeatherResponse(
    @SerializedName("current") val currentWeatherEntry: CurrentWeatherEntry,
    val location: Location,
    val request: Request
)