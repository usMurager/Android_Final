package com.example.androidfinal.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidfinal.R
import com.example.androidfinal.data.remote.models.CountryListApi
import com.example.androidfinal.domain.repositories.CountryRepository
import com.example.androidfinal.domain.viewModels.CountryListViewModel
import com.example.androidfinal.domain.viewModels.CountryListViewModelFactory
import com.example.androidfinal.ui.adapters.CountryListAdapter
import com.example.androidfinal.ui.adapters.listeners.CountryListListener
import kotlinx.android.synthetic.main.fragment_first.*


class FirstFragment : Fragment(), CountryListListener {
    private lateinit var adapter: CountryListAdapter
    private lateinit var viewModel: CountryListViewModel
    private lateinit var viewModelFactory: CountryListViewModelFactory
    private lateinit var repository: CountryRepository

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(activity)
        adapter = CountryListAdapter(this)

        country_list.layoutManager = layoutManager
        country_list.adapter = adapter

        repository = CountryRepository()
        viewModelFactory = CountryListViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[CountryListViewModel::class.java]

        viewModel.getCountryList()

        viewModel.countriesResponse.observe(viewLifecycleOwner) { countryList ->
            adapter.submitList(countryList)
        }
    }

    override fun getCountry(country: CountryListApi) {
        val bundle = bundleOf("country_slug" to country.slug)
        findNavController().navigate(R.id.action_firstFragment_to_secondFragment, bundle)
    }
}