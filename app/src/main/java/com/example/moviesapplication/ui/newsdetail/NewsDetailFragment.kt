package com.example.moviesapplication.ui.newsdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.moviesapplication.databinding.FragmentNewsDetailBinding

class NewsDetailFragment : Fragment() {

    private lateinit var binding: FragmentNewsDetailBinding
    private val articleArguments: NewsDetailFragmentArgs by navArgs()

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
        articleArguments.newsDetail.let { article ->
            binding.newsDetailFragmentViewState = NewsDetailViewStateScreen(article)
        }
    }
}