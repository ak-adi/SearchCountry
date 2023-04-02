package com.example.countrysearch

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.countrysearch.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
  private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)
    val call: Call<CountryResponse> = RetrofitCountry().getInstance()!!.countryAPI.getNationality("yachika")

    binding.button.setOnClickListener {
      call.enqueue(
        object : Callback<CountryResponse> {
          override fun onResponse(
            call: Call<CountryResponse>,
            response: Response<CountryResponse>
          ) {
            val responseBody = response.body()
            Log.d("ajsdghfa", responseBody!!.name)
          }

          override fun onFailure(call: Call<CountryResponse>, t: Throwable) {

            Log.d("ajsdghfa", t.message.toString())
          }
        })

    }

  }
}
