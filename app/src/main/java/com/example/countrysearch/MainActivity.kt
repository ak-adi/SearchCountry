package com.example.countrysearch

import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.countrysearch.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
  private lateinit var binding: ActivityMainBinding
  private var searchText = ""

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    binding.searchView.setOnQueryTextListener(
        object : SearchView.OnQueryTextListener {
          override fun onQueryTextSubmit(query: String?): Boolean {

            return true
          }

          override fun onQueryTextChange(newText: String?): Boolean {
            searchText = newText!!
            Toast.makeText(this@MainActivity, searchText, Toast.LENGTH_LONG).show()
            return true
          }
        })

    binding.button.setOnClickListener { callAPI() }
  }

  private fun callAPI() {
    RetrofitCountry()
        .getInstance()!!
        .countryAPI
        .getNationality(searchText)
        .enqueue(
            object : Callback<CountryResponse> {
              override fun onResponse(
                  call: Call<CountryResponse>,
                  response: Response<CountryResponse>
              ) {
                val responseBody = response.body()
                Log.d("afddf", "onResponse: ${responseBody!!.name}")
              }

              override fun onFailure(call: Call<CountryResponse>, t: Throwable) {
                Snackbar.make(binding.root, t.message.toString(), Snackbar.LENGTH_LONG).show()
              }
            })
  }
}
