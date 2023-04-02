package com.example.countrysearch

import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.countrysearch.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
  private lateinit var binding: ActivityMainBinding
  private var searchText = ""
  private lateinit var adapter : CountryAdapter
  private lateinit var list : List<CountryResponse.Country>

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)
      binding.recyclerView.setHasFixedSize(true)
      binding.recyclerView.layoutManager = LinearLayoutManager(this)



    binding.searchView.setOnQueryTextListener(
        object : SearchView.OnQueryTextListener {
          override fun onQueryTextSubmit(query: String?): Boolean {

            return true
          }

          override fun onQueryTextChange(newText: String?): Boolean {
            searchText = newText!!
            return true
          }
        })

    binding.button.setOnClickListener { callAPI() }
      list = listOf<CountryResponse.Country>()
     adapter = CountryAdapter(list)
      binding.recyclerView.adapter = adapter

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
                Log.d("error", "onResponse: ${responseBody!!.name}")
              }

              override fun onFailure(call: Call<CountryResponse>, t: Throwable) {
                Snackbar.make(binding.root, t.message.toString(), Snackbar.LENGTH_LONG).show()
              }
            })
  }
}
