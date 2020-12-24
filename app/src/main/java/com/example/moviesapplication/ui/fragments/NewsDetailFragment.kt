package com.example.moviesapplication.ui.fragments

import android.app.ActionBar
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.SupportActionModeWrapper
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.moviesapplication.R
import com.example.moviesapplication.databinding.FragmentHomeBinding
import com.example.moviesapplication.databinding.FragmentNewsDetailBinding

class NewsDetailFragment : Fragment() {

    private lateinit var binding: FragmentNewsDetailBinding
    val args: NewsDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewsDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUi()
        binding.collapsing.title = "Son Dakika"
    }

    private fun setUi() {
        binding.includeContent.title.text = args.newsDetail.title
        binding.includeContent.content.text =
            "${args.newsDetail.content} ${args.newsDetail.content} ${args.newsDetail.content} "
        binding.includeContent.publishAt.text = args.newsDetail.publishedAt
        context?.let {
            Glide.with(it).load(args.newsDetail.urlToImage).into(binding.detailIamge)
        }
        //Collaps olmazsa
        /*binding.title.text = args.newsDetail.title
        binding.content.text = args.newsDetail.content
        binding.publishAt.text = args.newsDetail.publishedAt*/
    }
}