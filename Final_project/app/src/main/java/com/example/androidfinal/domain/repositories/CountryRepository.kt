package com.example.androidfinal.domain.repositories

import com.example.androidfinal.data.remote.helpers.RetrofitFactory
import com.example.androidfinal.data.remote.models.CountryApi
import com.example.androidfinal.data.remote.models.CountryListApi
import retrofit2.Response

class CountryRepository {
    suspend fun getCountries(): Response<List<CountryListApi>> {
        return RetrofitFactory.getCountryService().getCountries()
    }

    suspend fun getCountry(slug: String): Response<List<CountryApi>> {
        return RetrofitFactory.getCountryService().getCountry(slug)
    }
}