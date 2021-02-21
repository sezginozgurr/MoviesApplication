package com.example.moviesapplication.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.moviesapplication.data.Status
import com.example.moviesapplication.data.Status.ERROR
import com.example.moviesapplication.data.Status.SUCCESS
import com.example.moviesapplication.data.model.Article
import com.example.moviesapplication.databinding.FragmentHomeBinding
import com.example.moviesapplication.ui.vm.HomePageViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val homeViewModel: HomePageViewModel by viewModels()
    private val newsAdapter = NewsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater).apply {
            lifecycleOwner = viewLifecycleOwner
            recycler.adapter = newsAdapter.apply {
                setOnArticleItemClickListener { article -> openNewsDetail(article) }
            }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObserver()
    }

    private fun initObserver() {
        homeViewModel.news.observe(viewLifecycleOwner) {
            it?.let {
                when (it.status) {
                    SUCCESS -> {
                        newsAdapter.setArticles(it.data?.articles ?: arrayListOf())
                    }
                    ERROR -> {
                        showErrorDialog(it.message)
                    }
                }
                setViewState(it.status)
            }
        }
    }

    private fun setViewState(status: Status) {
        binding.homeFragmentViewState = HomeFragmentViewState(status)
    }

    private fun showErrorDialog(message: String?) {
        AlertDialog.Builder(requireContext())
            .setTitle("Uyarı")
            .setMessage(message)
            .setPositiveButton("Tamam") { dialog, _ ->
                dialog.dismiss()
            }.create()
            .show()
    }

    private fun openNewsDetail(article: Article) {
        val action = HomeFragmentDirections.actionHomeFragmentToNewsDetailFragment(article)
        findNavController().navigate(action)
    }

}