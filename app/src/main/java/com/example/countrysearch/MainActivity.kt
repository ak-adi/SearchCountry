package com.example.countrysearch

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import com.example.countrysearch.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
  private lateinit var binding: ActivityMainBinding
  private var searchText = ""
  private lateinit var adapter: CountryAdapter

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
            return true
          }
        })

    binding.button.setOnClickListener {
      it.hideKeyboard()
      callAPI()
    }
  }
  private fun View.hideKeyboard() {
    val inputManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputManager.hideSoftInputFromWindow(windowToken, 0)
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
                val list = responseBody!!.country
                adapter = CountryAdapter(list)
                binding.recyclerView.adapter = adapter
              }

              override fun onFailure(call: Call<CountryResponse>, t: Throwable) {
                Snackbar.make(binding.root, "Something went wrong. Please try again.", Snackbar.LENGTH_LONG).show()
              }
            })
  }
}
