package com.example.moviesapplication.ui

import com.example.moviesapplication.data.model.Article
import com.example.moviesapplication.util.ConvertDateTime

data class NewsDetailViewStateScreen(val article: Article) {

    fun getTitle() = article.title

    fun getContent() = article.content

    fun getPublicationDate() = article.publishedAt?.let { ConvertDateTime().convertDate(it) }

    fun getImageUrl() = article.urlToImage

}