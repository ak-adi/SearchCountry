package com.example.countrysearch

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import androidx.appcompat.app.AppCompatActivity


open class RetrofitCountry {
    private var instance: RetrofitCountry? = null
    private val BASE_URL="https://api.nationalize.io/"

    @Synchronized
    fun getInstance(): RetrofitCountry? {
        if (instance == null) {
            instance = RetrofitCountry()
        }
        return instance
    }

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val countryAPI: CountryAPI = retrofit.create(CountryAPI::class.java)
}