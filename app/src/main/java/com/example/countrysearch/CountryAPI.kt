package com.example.countrysearch
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CountryAPI {
    @GET("/")
    fun getNationality(@Query("name") name : String): Call<CountryResponse>
}