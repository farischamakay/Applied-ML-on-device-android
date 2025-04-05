package com.dicoding.asclepius.data.api

import com.dicoding.asclepius.data.model.NewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface ApiService {
    @GET("v2/top-headlines")
    fun getNewsList(@QueryMap filter: HashMap<String, String>): Call<NewsResponse>
}