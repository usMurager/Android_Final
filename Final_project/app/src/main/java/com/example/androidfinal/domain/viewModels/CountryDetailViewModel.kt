package com.example.androidfinal.domain.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidfinal.data.remote.models.CountryApi
import com.example.androidfinal.domain.repositories.CountryRepository
import kotlinx.coroutines.launch

class CountryDetailViewModel(private val countryRepository: CountryRepository) : ViewModel() {
    val countryResponse: MutableLiveData<CountryApi> = MutableLiveData()
    val errorMessage: MutableLiveData<String> = MutableLiveData()

    fun getCountry(slug: String) {
        viewModelScope.launch {
            val response = countryRepository.getCountry(slug)
            if (response.isSuccessful) {
                countryResponse.value = response.body()?.last()
            } else {
                errorMessage.value = response.message()
            }
        }
    }
}