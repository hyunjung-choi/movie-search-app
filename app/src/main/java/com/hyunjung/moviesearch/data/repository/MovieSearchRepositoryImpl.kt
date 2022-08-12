package com.hyunjung.moviesearch.data.repository

import com.hyunjung.moviesearch.data.api.RetrofitInstance.api
import com.hyunjung.moviesearch.data.model.SearchResponse
import retrofit2.Response

class MovieSearchRepositoryImpl: MovieSearchRepository {
    override suspend fun searchMovies(query: String): Response<SearchResponse> {
        return api.searchMovies(query)
    }
}