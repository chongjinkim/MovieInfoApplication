package com.soomgo.movieinfoapplication.presentaion.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.soomgo.movieinfoapplication.databinding.LayoutItemFavoriteBinding
import com.soomgo.movieinfoapplication.domain.model.Movie

class FavoriteAdapter : ListAdapter<Movie, FavoriteAdapter.FavoriteViewHoler>(Movie.DiffUtil)  {

    var clickListener : ((Movie) -> (Unit))? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHoler {

        val view = LayoutItemFavoriteBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return FavoriteViewHoler(view)
    }

    override fun onBindViewHolder(holder: FavoriteViewHoler, position: Int) {
        holder.binding.apply {
            //livedata의 변경사항을 관찰해야할 lifecycleowner를 설정을 한다.
            setVariable(BR.movie, getItem(position))
            root.setOnClickListener {
                clickListener?.invoke(getItem(position))
                executePendingBindings()
            }
        }
    }

    inner class FavoriteViewHoler(val binding : LayoutItemFavoriteBinding) : RecyclerView.ViewHolder(binding.root)
}