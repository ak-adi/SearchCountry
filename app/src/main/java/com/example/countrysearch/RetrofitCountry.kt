package com.example.countrysearch

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


open class RetrofitCountry {
    private var instance: RetrofitCountry? = null
    private lateinit var myApi: CountryAPI
    private val BASE_URL="https://api.nationalize.io/"

    @Synchronized
    fun getInstance(): RetrofitCountry? {
        if (instance == null) {
            instance = RetrofitCountry()
        }
        return instance
    }

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val countryAPI = retrofit.create(CountryAPI::class.java)
}