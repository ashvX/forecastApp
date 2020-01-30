package e.erga.forecastmvvm.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import e.erga.forecastmvvm.data.db.entity.CURRENT_WEATHER_ID
import e.erga.forecastmvvm.data.db.entity.CurrentWeatherEntry
import e.erga.forecastmvvm.data.db.unitilocalized.ImperialCurrentWeatherEntry

@Dao
interface CurrentWeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upSert(weatherEntry: CurrentWeatherEntry)

    @Query("select * from current_weather where id = $CURRENT_WEATHER_ID")
    fun getWeather(): LiveData<ImperialCurrentWeatherEntry>

}