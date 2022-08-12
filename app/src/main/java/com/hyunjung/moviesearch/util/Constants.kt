package com.hyunjung.moviesearch.util

import com.hyunjung.moviesearch.BuildConfig

object Constants {
    const val BASE_URL = "https://openapi.naver.com/"
    const val CLIENT_ID = BuildConfig.clientId
    const val CLIENT_SECRET = BuildConfig.clientSecret
    const val SEARCH_TIME_DELAY = 100L
}