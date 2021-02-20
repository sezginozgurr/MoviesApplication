package com.example.moviesapplication.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.moviesapplication.data.model.Article
import com.example.moviesapplication.databinding.FragmentHomeBinding
import com.example.moviesapplication.ui.adapter.NewsAdapter
import com.example.moviesapplication.util.Status
import com.example.moviesapplication.vm.HomePageViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private val homeViewModel by viewModel<HomePageViewModel>()

    private val adapter = NewsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()

        bindObserve()
    }

    private fun initAdapter() {
        binding.adapter = adapter

        adapter.onClick {
            val action = HomeFragmentDirections.actionHomeFragmentToNewsDetailFragment(it)
            findNavController().navigate(action)
        }
    }

    private fun bindObserve() {
        homeViewModel.news.observe(viewLifecycleOwner) {
            it?.let {
                binding.state = it.status
                if (it.status == Status.SUCCESS) {
                    adapter.updateAdapter(it.data?.articles as ArrayList<Article>)
                }
            }
        }
    }
}