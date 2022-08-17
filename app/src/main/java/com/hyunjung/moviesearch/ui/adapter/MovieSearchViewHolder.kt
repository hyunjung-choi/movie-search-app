package com.hyunjung.moviesearch.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.hyunjung.moviesearch.data.model.Movie
import com.hyunjung.moviesearch.databinding.ItemMoviePreviewBinding

class MovieSearchViewHolder(
    private val binding: ItemMoviePreviewBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: Movie) {
        val title = movie.title
        val date = movie.pubDate
        val rate = movie.userRating

        itemView.apply {
            binding.ivItem.load(movie.image)
            binding.tvItemTitle.text = "제목: ${removeTag(title)}"
            binding.tvItemDate.text = "출시일: $date"
            binding.tvItemRate.text = "평점: $rate"
        }
    }

    private fun removeTag(title: String) =
        title.replace(Regex("[<b></b>]")) {
            when (it.value) {
                "<b>" -> ""
                "</b>" -> ""
                else -> ""
            }
        }

}