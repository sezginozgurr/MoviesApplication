package com.example.moviesapplication.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.moviesapplication.R
import com.example.moviesapplication.data.model.Article
import com.example.moviesapplication.databinding.FragmentHomeBinding
import com.example.moviesapplication.ui.adapter.NewsAdapter
import com.example.moviesapplication.ui.vm.HomePageViewModel


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
//    private val adapter = MoviesAdapter()

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
            Toast.makeText(context, it.status.toString(), Toast.LENGTH_SHORT).show()

            binding.recycler.adapter = NewsAdapter(it.articles as ArrayList<Article?>) {
                findNavController().navigate(R.id.newsDetailFragment)
            }
        }
    }

}