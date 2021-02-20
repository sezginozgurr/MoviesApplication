package com.example.moviesapplication.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapplication.R
import com.example.moviesapplication.data.model.Article
import com.example.moviesapplication.databinding.RowMoviesListBinding

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    private var articles = ArrayList<Article>()
    private lateinit var click: (Article) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding: RowMoviesListBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.row_movies_list,
            parent,
            false
        )
        return NewsViewHolder(binding)
    }

    override fun getItemCount(): Int = articles.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(articles[position], click)
    }

    fun updateAdapter(articles: ArrayList<Article>) {
        this.articles = articles
        notifyDataSetChanged()
    }

    fun onClick(click: (Article) -> Unit) {
        this.click = click
    }

    class NewsViewHolder(private val binding: RowMoviesListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(article: Article, click: (Article) -> Unit) {
            binding.data = article
            binding.root.setOnClickListener {
                click(article)
            }
        }
    }
}