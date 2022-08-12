package com.hyunjung.moviesearch.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hyunjung.moviesearch.data.model.SearchResponse
import com.hyunjung.moviesearch.data.repository.MovieSearchRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieSearchViewModel(
    private val movieSearchRepository: MovieSearchRepository
) : ViewModel() {

    private val _serchResult = MutableLiveData<SearchResponse>()
    val searchResult: LiveData<SearchResponse> get() = _serchResult

    fun searchMovies(query: String) = viewModelScope.launch(Dispatchers.IO) {
        val response = movieSearchRepository.searchMovies(query)

        if(response.isSuccessful) {
            response.body()?.let { body ->
                _serchResult.postValue(body)
            }
        }
    }




}