package e.erga.forecastmvvm.ui.weather.current

import androidx.lifecycle.ViewModel
import e.erga.forecastmvvm.data.repository.ForecastRepository
import e.erga.forecastmvvm.internal.lazyDeferred

class CurrentWeatherViewModel(
    private val forecastRepository: ForecastRepository
) : ViewModel() {

    val isImperial: Boolean
    get() = true
    val weather by lazyDeferred {
        forecastRepository.getCurrentWeather(isImperial)
    }
}
