package e.erga.forecastmvvm.data.db.unitilocalized

interface UnitSpecificCurrentWeatherEntry {
    val isDay: String
    val observationTime: String
    val precip: Double
    val temperature: Int
    val weatherCode: Int
    val windDir: String
    val windSpeed: Int
}