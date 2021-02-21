package com.example.moviesapplication.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapplication.data.model.Article
import com.example.moviesapplication.databinding.RowMoviesListBinding

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    private val articles = arrayListOf<Article>()
    private var articleItemClickListener: ((article: Article) -> Unit)? = null

    fun setArticles(articles: List<Article>) {
        this.articles.apply {
            clear()
            addAll(articles)
        }
        notifyDataSetChanged()
    }

    fun setOnArticleItemClickListener(articleItemClickListener: ((article: Article) -> Unit)?) {
        this.articleItemClickListener = articleItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val rowMoviesListBinding =
            RowMoviesListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(rowMoviesListBinding)

    }

    override fun getItemCount(): Int = articles.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(articles[position])
    }

    inner class NewsViewHolder(private val binding: RowMoviesListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener { articleItemClickListener?.invoke(articles[adapterPosition]) }
        }

        fun bind(article: Article) {
            with(binding) {
                data = article
                executePendingBindings()
            }
        }
    }

}