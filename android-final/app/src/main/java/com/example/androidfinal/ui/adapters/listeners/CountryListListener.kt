package com.example.androidfinal.ui.adapters.listeners

import com.example.androidfinal.data.remote.models.CountryListApi

interface CountryListListener {
    fun getCountry(country: CountryListApi)
}