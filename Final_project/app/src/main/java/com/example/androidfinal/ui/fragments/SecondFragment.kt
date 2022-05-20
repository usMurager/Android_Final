package com.example.androidfinal.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidfinal.R
import com.example.androidfinal.data.remote.models.CountryApi
import com.example.androidfinal.domain.repositories.CountryRepository
import com.example.androidfinal.domain.viewModels.CountryDetailViewModel
import com.example.androidfinal.domain.viewModels.CountryDetailViewModelFactory
import com.example.androidfinal.domain.viewModels.CountryListViewModel
import com.example.androidfinal.domain.viewModels.CountryListViewModelFactory
import com.example.androidfinal.ui.adapters.CountryListAdapter
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.fragment_second.*


class SecondFragment : Fragment() {
    private lateinit var viewModel: CountryDetailViewModel
    private lateinit var viewModelFactory: CountryDetailViewModelFactory
    private lateinit var repository: CountryRepository

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        repository = CountryRepository()
        viewModelFactory = CountryDetailViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[CountryDetailViewModel::class.java]

        val countrySlug = arguments?.getString("country_slug")!!
        viewModel.getCountry(countrySlug)

        viewModel.countryResponse.observe(viewLifecycleOwner) { country ->
            bind(country)
        }
    }

    fun bind(country: CountryApi) {
        country_name.text = country.country
        country_slug.text = country.code
        country_confirmed.text = country.confirmed.toString()
        country_deaths.text = country.deaths.toString()
        country_active.text = country.active.toString()
    }
}