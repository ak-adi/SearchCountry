package com.example.countrysearch

data class CountryResponse(
    val name: String,
    val country: List<Country>

){
    data class Country(val country_id : String, val probability : Double)
}
