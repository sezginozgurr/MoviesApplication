package com.example.moviesapplication.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.moviesapplication.Util.Status
import com.example.moviesapplication.data.model.MoviesResponse
import com.example.moviesapplication.data.model.TvShow
import com.example.moviesapplication.data.repository.HomePageRepository
import com.example.moviesapplication.data.service.ApiService
import com.example.moviesapplication.data.service.RetrofitClient
import com.example.moviesapplication.databinding.FragmentHomeBinding
import com.example.moviesapplication.ui.adapter.MoviesAdapter
import com.example.moviesapplication.ui.vm.HomePageViewModel
import com.example.moviesapplication.ui.vm.MyViewModelFactory
import java.util.Observer


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomePageViewModel
    private var bakinglist = ArrayList<TvShow?>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val viewModelFactory =
            MyViewModelFactory(
                repository = HomePageRepository(
                    RetrofitClient.getRetrofit().create(ApiService::class.java)
                )
            )
        viewModel = ViewModelProvider(this, viewModelFactory).get(HomePageViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.movies.observe(viewLifecycleOwner) {
            when (it.status) {
                Status.SUCCESS -> {
                    bakinglist = it.data as ArrayList<TvShow?>

                    binding.recycler.adapter = MoviesAdapter(bakinglist)
                }
            }

        }
    }

}