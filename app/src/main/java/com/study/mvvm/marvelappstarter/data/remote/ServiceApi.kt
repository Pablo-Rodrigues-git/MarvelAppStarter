package com.study.mvvm.marvelappstarter.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceApi {

    @GET("characters")
    suspend fun list(
        @Query("nameStartsWith") nameStartsWith: String? = null
    )
}