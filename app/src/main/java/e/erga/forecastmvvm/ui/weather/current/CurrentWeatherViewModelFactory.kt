package e.erga.forecastmvvm.ui.weather.current

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import e.erga.forecastmvvm.data.repository.ForecastRepository

class CurrentWeatherViewModelFactory(
    private val forecastRepository: ForecastRepository
): ViewModelProvider.NewInstanceFactory(){
    override fun <T: ViewModel?> create(modelClass: Class<T>): T{
        return CurrentWeatherViewModel(forecastRepository) as T
    }
}