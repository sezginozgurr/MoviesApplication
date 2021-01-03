package com.example.moviesapplication.ui

import com.example.moviesapplication.Util.ConvertDateTime
import com.example.moviesapplication.data.model.Article

data class NewsDetailViewStateScreen(val article: Article) {

    fun getTitle() = article.title

    fun getContent() = article.content

    fun getPublicationDate() = article.publishedAt?.let { ConvertDateTime().convertDate(it) }

    fun getImageUrl() = article.urlToImage

}