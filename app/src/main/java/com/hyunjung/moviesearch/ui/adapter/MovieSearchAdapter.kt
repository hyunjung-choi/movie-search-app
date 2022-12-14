package com.hyunjung.moviesearch.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.hyunjung.moviesearch.data.model.Movie
import com.hyunjung.moviesearch.databinding.ItemMoviePreviewBinding

class MovieSearchAdapter: ListAdapter<Movie, MovieSearchViewHolder>(MovieDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieSearchViewHolder {
        return MovieSearchViewHolder(
            ItemMoviePreviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: MovieSearchViewHolder, position: Int) {
        val movie = currentList[position]
        holder.bind(movie)
    }

    companion object {
        private val MovieDiffCallback = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem == newItem
            }
        }
    }
}