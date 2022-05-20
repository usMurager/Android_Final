package com.example.androidfinal.data.remote.models

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class CountryListApi(
    @SerializedName("Country")
    val country: String,
    @SerializedName("Slug")
    val slug: String,
    @SerializedName("ISO2")
    val iso2: String
) {
}