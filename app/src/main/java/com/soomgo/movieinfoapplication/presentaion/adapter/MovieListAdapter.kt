package com.soomgo.movieinfoapplication.presentaion.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.soomgo.movieinfoapplication.databinding.LayoutItemMovieBinding
import com.soomgo.movieinfoapplication.domain.model.Movie

class MovieListAdapter : ListAdapter<Movie, MovieListAdapter.MovieListViewHolder>(Movie.DiffUtil){

    var clickListener: ((Movie) -> (Unit))? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {

        val view = LayoutItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MovieListViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        holder.binding.apply {
            setVariable(BR.movie, getItem(position))
            root.setOnClickListener {clickListener?.invoke(getItem(position))}
            executePendingBindings()
        }
    }

    inner class MovieListViewHolder(val binding : LayoutItemMovieBinding) : RecyclerView.ViewHolder(binding.root)
}