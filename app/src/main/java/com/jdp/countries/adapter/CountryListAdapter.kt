package com.jdp.countries.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jdp.countries.data.CountryItem
import com.jdp.countries.databinding.CountryItemViewBinding

class CountryListAdapter(
    private val openDetailsView: (
        binding: CountryItemViewBinding,
        countryItem: CountryItem
    ) -> Unit
) : ListAdapter<CountryItem, RecyclerView.ViewHolder>(DIFF_CALLBACK) {

    private companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<CountryItem>() {
            override fun areContentsTheSame(oldItem: CountryItem, newItem: CountryItem): Boolean =
                oldItem.checkContentEquals(newItem)

            override fun areItemsTheSame(oldItem: CountryItem, newItem: CountryItem): Boolean =
                oldItem.checkItemEquals(newItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding: CountryItemViewBinding =
            CountryItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        val countryViewHolder = CountryItemViewHolder(binding)
        countryViewHolder.itemView.setOnClickListener {
            openDetailsView.invoke(
                binding,
                getItem(countryViewHolder.adapterPosition)
            )
        }
        return countryViewHolder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CountryItemViewHolder -> holder.bind(getItem(position))
        }
    }

    fun setItems(list: List<CountryItem>) {
        submitList(list)
    }
}

class CountryItemViewHolder(
    private val binding: CountryItemViewBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: CountryItem) {
        binding.countryItem = item
        binding.executePendingBindings()
    }
}

