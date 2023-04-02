package com.example.countrysearch
import com.example.countrysearch.CountryResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CountryAPI {
    @GET("/?name=yachika")
    fun getNationality(@Query("name") name: String): retrofit2.Call<CountryResponse>
}