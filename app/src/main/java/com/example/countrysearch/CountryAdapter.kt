package com.example.countrysearch

import android.content.Context
import android.telecom.Call
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CountryAdapter(private val context : Context, private val countryList : List<Any>) : RecyclerView.Adapter<CountryAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.list_item, parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val count = countryList[position]

    }

    override fun getItemCount(): Int {
         return countryList.size
    }
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val name = itemView.findViewById<TextView>(R.id.name)
        val country = itemView.findViewById<TextView>(R.id.country)
        val search = itemView.findViewById<SearchView>(R.id.searchView)
    }



}