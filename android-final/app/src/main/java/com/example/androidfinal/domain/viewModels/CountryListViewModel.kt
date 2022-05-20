package com.example.androidfinal.domain.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidfinal.data.remote.models.CountryListApi
import com.example.androidfinal.domain.repositories.CountryRepository
import kotlinx.coroutines.launch

class CountryListViewModel(private val countryRepository: CountryRepository) : ViewModel() {
    val countriesResponse: MutableLiveData<List<CountryListApi>> = MutableLiveData()
    val errorMessage: MutableLiveData<String> = MutableLiveData()

    fun getCountryList() {
        viewModelScope.launch {
            val response = countryRepository.getCountries()
            if (response.isSuccessful) {
                countriesResponse.value = response.body()
            } else {
                errorMessage.value = response.message()
            }
        }
    }
}