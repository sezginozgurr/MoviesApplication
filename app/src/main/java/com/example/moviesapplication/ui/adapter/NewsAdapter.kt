package com.example.moviesapplication.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapplication.BR
import com.example.moviesapplication.R
import com.example.moviesapplication.data.model.Article
import com.example.moviesapplication.databinding.RowMoviesListBinding

class NewsAdapter(
    var context: Context,
    var articles: ArrayList<Article>,
    val click: (Article) -> Unit
) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding: RowMoviesListBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.row_movies_list,
            parent,
            false
        )
        return NewsViewHolder(binding)
    }

    override fun getItemCount(): Int = articles.size


    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(articles.get(position), click)
    }

    class NewsViewHolder(val binding: RowMoviesListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Article, click: (Article) -> Unit) {
            binding.setVariable(BR.data, data)
            binding.executePendingBindings()

            itemView.setOnClickListener {
                click(data)
            }
        }
    }

}