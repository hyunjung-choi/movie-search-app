package com.hyunjung.moviesearch.data.repository

import com.hyunjung.moviesearch.data.model.SearchResponse
import retrofit2.Response

interface MovieSearchRepository {

    suspend fun searchMovies(
        query: String
    ) : Response<SearchResponse>
}