package com.example.moviesapplication.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.moviesapplication.data.model.MoviesResponse
import com.example.moviesapplication.data.model.TvShow
import com.example.moviesapplication.databinding.FragmentHomeBinding
import com.example.moviesapplication.ui.adapter.MoviesAdapter
import com.example.moviesapplication.ui.vm.HomePageViewModel


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private var movieList = ArrayList<TvShow?>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val homeViewModel =
            ViewModelProvider(this, HomePageViewModel.Factory()).get(HomePageViewModel::class.java)
        homeViewModel.moviesResponses.observe(viewLifecycleOwner) {
            binding.recycler.adapter
        }
    }

}