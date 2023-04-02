package com.example.countrysearch

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.countrysearch.databinding.ListItemBinding

class CountryAdapter(private val context: Context, private val countryList: List<Any>) :
    ListAdapter<CountryResponse.Country, CountryAdapter.CountryViewHolder>(DIFF_UTIL()) {
  class CountryViewHolder(binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)

  companion object {
    class DIFF_UTIL : DiffUtil.ItemCallback<CountryResponse.Country>() {
      override fun areItemsTheSame(
          oldItem: CountryResponse.Country,
          newItem: CountryResponse.Country
      ): Boolean = oldItem.country_id == newItem.country_id

      override fun areContentsTheSame(
          oldItem: CountryResponse.Country,
          newItem: CountryResponse.Country
      ): Boolean = oldItem.country_id == newItem.country_id
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {}

  override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {}
}
