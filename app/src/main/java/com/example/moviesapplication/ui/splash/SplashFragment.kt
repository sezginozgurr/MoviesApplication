package com.example.moviesapplication.ui.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.moviesapplication.R
import com.example.moviesapplication.databinding.FragmentSplashBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SplashFragment : Fragment() {
    private lateinit var binding: FragmentSplashBinding

    init {
        lifecycleScope.launchWhenResumed {
            showAnimation()
            openHomePage()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun showAnimation() {
        binding.lotties.playAnimation()
    }

    private suspend fun openHomePage() {
        delay(2700)
        findNavController().popBackStack()
        findNavController().navigate(R.id.homeFragment)
    }

}