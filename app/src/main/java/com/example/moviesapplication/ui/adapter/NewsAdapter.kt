package com.example.moviesapplication.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesapplication.R
import com.example.moviesapplication.data.model.Article

class NewsAdapter(
    private val articleList: ArrayList<Article?>,
    private val onClick: (Article) -> Unit
):
    RecyclerView.Adapter<NewsAdapter.MoviesHolder>() {

    class MoviesHolder(container: ViewGroup) :
        RecyclerView.ViewHolder(
            LayoutInflater.from(container.context)
                .inflate(R.layout.row_movies_list, container, false)
        ) {
        private val imageView = itemView.findViewById(R.id.moviesPhoto) as ImageView
        private val title = itemView.findViewById(R.id.moviesName) as TextView
        private val newsName = itemView.findViewById(R.id.newsName) as TextView

        fun bind(articleModel: Article, onClick: (Article) -> Unit) {
            Glide.with(imageView).load(articleModel.urlToImage)
                .into(imageView)
            title.text = articleModel.title
            newsName.text = articleModel.source?.name
            itemView.setOnClickListener {
                onClick(articleModel)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.MoviesHolder {
        return MoviesHolder(parent)
    }

    override fun onBindViewHolder(holder: MoviesHolder, position: Int) {
        articleList[position]?.let { holder.bind(it, onClick) }
    }

    override fun getItemCount(): Int = articleList.size

}