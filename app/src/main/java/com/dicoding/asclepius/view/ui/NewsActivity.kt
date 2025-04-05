package com.dicoding.asclepius.view.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.asclepius.data.model.ArticlesItem
import com.dicoding.asclepius.databinding.ActivityNewsBinding
import com.dicoding.asclepius.view.adapter.NewsAdapter
import com.dicoding.asclepius.view.viewmodel.NewsActivityViewModel

class NewsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[NewsActivityViewModel::class.java]

        viewModel.listNews.observe(this) { listNews ->
            setNewsData(listNews)
        }

        viewModel.isLoading.observe(this) {
            showLoading(it)
        }
    }

    private fun setNewsData(news: List<ArticlesItem>) {
        val adapter = NewsAdapter()
        adapter.submitList(news)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
}