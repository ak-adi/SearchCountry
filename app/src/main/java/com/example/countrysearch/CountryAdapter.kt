package com.example.countrysearch

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CountryAdapter(private val countryList: List<CountryResponse.Country>): RecyclerView.Adapter<CountryAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val count = countryList[position]
        holder.country.text = count.country_id
        holder.probability.text = count.probability.toString()


    }

    override fun getItemCount(): Int {
       return countryList.size
    }
    class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){

        val country = itemView.findViewById<TextView>(R.id.countryName)
        val probability = itemView.findViewById<TextView>(R.id.probability)

    }

}
