package com.example.androidfinal.data.remote.models

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class CountryApi(
    @SerializedName("Country")
    val country: String,
    @SerializedName("CountryCode")
    val code: String,
    @SerializedName("Confirmed")
    val confirmed: Int,
    @SerializedName("Deaths")
    val deaths: Int,
    @SerializedName("Active")
    val active: Int
) {
}