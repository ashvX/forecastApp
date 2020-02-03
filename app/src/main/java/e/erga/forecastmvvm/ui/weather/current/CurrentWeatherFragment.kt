package e.erga.forecastmvvm.ui.weather.current

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import e.erga.forecastmvvm.R
import e.erga.forecastmvvm.data.CurrentWeatherResponse
import e.erga.forecastmvvm.data.network.ApixuWeatherApiService
import e.erga.forecastmvvm.data.network.ConnectivityInterceptor
import e.erga.forecastmvvm.data.network.ConnectivityInterceptorImpl
import e.erga.forecastmvvm.data.network.WeatherNetworkDataSourceImpl
import e.erga.forecastmvvm.ui.base.ScopedFragment
import kotlinx.android.synthetic.main.current_weather_fragment.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance

class CurrentWeatherFragment : ScopedFragment(), KodeinAware {
    override val kodein by closestKodein()
    private val viewModelFactory: CurrentWeatherViewModelFactory by instance()
    private lateinit var viewModel: CurrentWeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.current_weather_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(CurrentWeatherViewModel::class.java)

        fun bindUi() = launch{
            val currentWeather = viewModel.weather.await()
            currentWeather.observe(viewLifecycleOwner, Observer {
                textView.text = it.toString()
            })
        }
        /*val apiService = ApixuWeatherApiService(ConnectivityInterceptorImpl(this.context!!))
        val weatherNetworkDataSource = WeatherNetworkDataSourceImpl(apiService)

        weatherNetworkDataSource.downloadCurrentWeather.observe(viewLifecycleOwner, Observer {
            textView.text = it.toString()
        })

        GlobalScope.launch (Dispatchers.Main ) {
            //val currentWeatherResponse = apiService.getCurrentWeatherAsync().await()
            //textView.text = currentWeatherResponse.toString()

            weatherNetworkDataSource.fetchCurrentWeather("Bandung")
        }*/
    }
}
