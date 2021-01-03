package com.example.moviesapplication.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.moviesapplication.data.model.Article
import com.example.moviesapplication.databinding.FragmentHomeBinding
import com.example.moviesapplication.ui.adapter.NewsAdapter
import com.example.moviesapplication.ui.vm.HomePageViewModel


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    lateinit var homeViewModel: HomePageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel =
            ViewModelProvider(this, HomePageViewModel.Factory()).get(HomePageViewModel::class.java)

        initialize()
    }

    private fun initialize() {
        homeViewModel.newsResponse.observe(viewLifecycleOwner) {
            val adapter =
                NewsAdapter(requireContext(), it.articles as ArrayList<Article>) { article ->
                    val action =
                        HomeFragmentDirections.actionHomeFragmentToNewsDetailFragment(article)
                    findNavController().navigate(action)
                }
            binding.recycler.adapter = adapter
            binding.executePendingBindings()
        }

        homeViewModel.errorBody?.observe(viewLifecycleOwner) {
            Toast.makeText(context, "Cano olmadi tekrar dene", Toast.LENGTH_SHORT).show()
        }
    }

}