package com.example.moviesapplication.ui.newsdetail

import com.example.moviesapplication.data.model.Article
import com.example.moviesapplication.util.UtilityDate.convertDate

data class NewsDetailViewStateScreen(val article: Article) {

    fun getTitle() = article.title

    fun getContent() = article.content

    fun getPublicationDate() = article.publishedAt?.let { convertDate(it) }

    fun getImageUrl() = article.urlToImage

}