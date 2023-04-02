package com.example.countrysearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val retro=  RetrofitCountry()
       val call:Call<CountryResponse> = retro.countryAPI.getNationality("")
        call.enqueue(object : Callback<CountryResponse>{
            override fun onResponse(
                call: Call<CountryResponse>,
                response: Response<CountryResponse>
            ) {
                val responseBody = response.body()
                Log.d("ajsdghfa",responseBody!!.name)
            }

            override fun onFailure(call: Call<CountryResponse>, t: Throwable) {

                Log.d("ajsdghfa",t.message.toString())
            }

        })



    }
}