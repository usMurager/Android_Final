package com.example.androidfinal.data.remote.helpers

import android.content.Context
import com.example.androidfinal.data.remote.services.CountryService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {

    companion object {
        private const val BASE_URL = "https://api.covid19api.com/";

        private fun getRetrofitClientPublic(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        fun getCountryService(): CountryService =
            getRetrofitClientPublic().create(CountryService::class.java)

    }
}