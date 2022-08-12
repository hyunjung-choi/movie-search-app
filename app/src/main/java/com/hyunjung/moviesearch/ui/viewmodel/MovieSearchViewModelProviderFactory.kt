package com.hyunjung.moviesearch.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hyunjung.moviesearch.data.repository.MovieSearchRepository

class MovieSearchViewModelProviderFactory(
    private val movieSearchRepository: MovieSearchRepository
    ) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieSearchViewModel::class.java)) {
            return MovieSearchViewModel(movieSearchRepository) as T
        }
        throw IllegalArgumentException("ViewModel class not found")
    }
}