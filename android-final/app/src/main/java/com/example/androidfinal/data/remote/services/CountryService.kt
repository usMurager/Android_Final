package com.example.androidfinal.data.remote.services

import com.example.androidfinal.data.remote.models.CountryApi
import com.example.androidfinal.data.remote.models.CountryListApi
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CountryService {
    @GET("countries")
    suspend fun getCountries(): Response<List<CountryListApi>>

    @GET("country/{slug}")
    suspend fun getCountry(@Path("slug") slug: String): Response<List<CountryApi>>
}