package com.example.moviesapplication.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.moviesapplication.R
import com.example.moviesapplication.databinding.FragmentSplashBinding
import com.example.moviesapplication.ui.MainActivity


class SplashFragment : Fragment() {

    private lateinit var binding: FragmentSplashBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lotties()
    }

    fun lotties() {
        val background = object : Thread() {
            override fun run() {
                binding.lotties.playAnimation()
                try {
                    sleep(2700)
                    findNavController().navigate(R.id.homeFragment)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
        background.start()
    }

}