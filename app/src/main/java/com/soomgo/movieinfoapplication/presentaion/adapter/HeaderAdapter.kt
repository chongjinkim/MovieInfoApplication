package com.soomgo.movieinfoapplication.presentaion.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.soomgo.movieinfoapplication.databinding.LayoutItemHeaderBinding

class HeaderAdapter(private val title : String,
                    private val description : String) : RecyclerView.Adapter<HeaderAdapter.HeaderViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeaderViewHolder {

        val view = LayoutItemHeaderBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return HeaderViewHolder(view)
    }

    override fun onBindViewHolder(holder: HeaderViewHolder, position: Int) {
        holder.binding.apply {
            headerTitleText.text = title
            headerCategoryText.text = description
        }
    }

    override fun getItemCount() = 1

    inner class HeaderViewHolder(val binding : LayoutItemHeaderBinding) : RecyclerView.ViewHolder(binding.root)
}