package com.example.androidfinal.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.androidfinal.R
import com.example.androidfinal.data.remote.models.CountryListApi
import com.example.androidfinal.ui.adapters.listeners.CountryListListener

class CountryListAdapter(private val selectListener: CountryListListener) :
    ListAdapter<CountryListApi, CountryListAdapter.CountryViewHolder>(DIFF_CONFIG) {
    companion object {
        val DIFF_CONFIG = object : DiffUtil.ItemCallback<CountryListApi>() {
            override fun areItemsTheSame(
                oldItem: CountryListApi,
                newItem: CountryListApi
            ): Boolean {
                return oldItem.country == newItem.country
            }

            override fun areContentsTheSame(
                oldItem: CountryListApi,
                newItem: CountryListApi
            ): Boolean {
                return oldItem.country == newItem.country
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.country_item, parent, false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = getItem(position)
        holder.bind(country)
        holder.itemView.setOnClickListener {
            selectListener.getCountry(country)
        }
    }

    inner class CountryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val countryIso: TextView = view.findViewById<TextView>(R.id.country_iso2)
        private val countryName: TextView = view.findViewById<TextView>(R.id.country_name)
        private val countrySlug: TextView = view.findViewById<TextView>(R.id.country_slug)

        fun bind(countryListApi: CountryListApi) {
            countryIso.text = countryListApi.iso2
            countryName.text = countryListApi.country
            countrySlug.text = countryListApi.slug
        }
    }

}