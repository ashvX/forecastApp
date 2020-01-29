package e.erga.forecastmvvm.data.db.unitilocalized

data class ImperialCurrentWeatherEntry (

    val id: Int,
    override val isDay: String,
    override val observationTime: String,
    override val precip: Double,
    override val temperature: Int,
    override val weatherCode: Int,
    override val windDir: String,
    override val windSpeed: Int

): UnitSpecificCurrentWeatherEntry