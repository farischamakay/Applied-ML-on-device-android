package com.dicoding.asclepius.view.viewmodel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dicoding.asclepius.data.api.ApiConfig
import com.dicoding.asclepius.data.model.ArticlesItem
import com.dicoding.asclepius.data.model.NewsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsActivityViewModel : ViewModel() {

    private val _listNews = MutableLiveData<List<ArticlesItem>>()
    val listNews: LiveData<List<ArticlesItem>> = _listNews

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading


    init {
        loadNews()
    }

    fun loadNews() {
        _isLoading.value = true
        val filter = HashMap<String, String>()
        filter["q"] = "cancer"
        filter["category"] = "health"
        filter["language"] = "en"
        filter["apiKey"] = "9e52ec70a419430da4cdfd3118717adc"

        val client = ApiConfig.getApiService().getNewsList(filter)
        client.enqueue(object : Callback<NewsResponse> {
            override fun onResponse(
                call: Call<NewsResponse>,
                response: Response<NewsResponse>
            ) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    _listNews.value = response.body()?.articles
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                _isLoading.value = false
                Log.e(TAG, "onFailure : ${t.message.toString()}")

            }

        })
    }


}