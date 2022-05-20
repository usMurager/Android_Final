package com.example.androidfinal.domain.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidfinal.domain.repositories.CountryRepository

class CountryListViewModelFactory(private val countryRepository: CountryRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CountryListViewModel(countryRepository) as T
    }
}