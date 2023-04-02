package com.example.countrysearch

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitCountry {

    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.nationalize.io/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val countryAPI = retrofit.create(CountryAPI::class.java)
}