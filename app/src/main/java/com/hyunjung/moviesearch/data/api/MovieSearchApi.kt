package com.hyunjung.moviesearch.data.api

import com.hyunjung.moviesearch.data.model.SearchResponse
import com.hyunjung.moviesearch.util.Constants.CLIENT_ID
import com.hyunjung.moviesearch.util.Constants.CLIENT_SECRET
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface MovieSearchApi {

    @Headers("X-Naver-Client-Id: {$CLIENT_ID}", "X-Naver-Client-Secret: {$CLIENT_SECRET}")
    @GET("v1/search/movie.json")
    suspend fun searchMovies(
        @Query("query") query: String
    ): Response<SearchResponse>
}