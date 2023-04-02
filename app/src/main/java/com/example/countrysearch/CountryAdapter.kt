package com.example.countrysearch

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.countrysearch.databinding.ListItemBinding

class CountryAdapter(private val countryList: List<CountryResponse.Country>) :
    RecyclerView.Adapter<CountryAdapter.ViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context))
    return ViewHolder(binding)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val count = countryList[position]
    holder.binding.countryName.text = count.country_id
    holder.binding.probability.text = count.probability.toString()
  }

  override fun getItemCount(): Int {
    return countryList.size
  }
  class ViewHolder(var binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)
}
