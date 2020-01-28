package e.erga.forecastmvvm.data.db.network.response

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import e.erga.forecastmvvm.data.CurrentWeatherResponse
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "c54f10082c792e74aa1089d6c277d5c0"

//https://api.weatherstack.com/current?access_key=c54f10082c792e74aa1089d6c277d5c0&query=

interface ApixuWeatherApiService {

    @GET("current")
    fun getCurrentWeatherAsync(
        @Query("query") location: String = "London"//,
        //@Query ("language ") languageCode: String = "en"
    ): Deferred <CurrentWeatherResponse>
    //Deferred is part of Coroutines Kotlin

    companion object{
        operator fun invoke():ApixuWeatherApiService{
           val requestInterceptor = Interceptor {chain ->

               val url = chain.request()
                   .url()
                   .newBuilder()
                   .addQueryParameter("access_key", API_KEY)
                   .build()

               val request = chain.request()
                   .newBuilder()
                   .url(url)
                   .build()

               return@Interceptor chain.proceed(request)
           }

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://api.weatherstack.com/")
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApixuWeatherApiService::class.java)
        }
    }

}