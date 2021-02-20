package com.example.moviesapplication.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.moviesapplication.databinding.FragmentNewsDetailBinding
import com.example.moviesapplication.ui.NewsDetailViewStateScreen

class NewsDetailFragment : Fragment() {

    private lateinit var binding: FragmentNewsDetailBinding
    val articles: NewsDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewsDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
        articles.newsDetail.let { article ->
            binding.newsDetailFragmentViewState = NewsDetailViewStateScreen(article)
        }
    }
}