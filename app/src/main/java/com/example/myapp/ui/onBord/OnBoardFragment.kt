package com.example.myapp.ui.onBord

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapp.databinding.FragmentOnBoardBinding
import com.example.myapp.ui.onBord.adapter.OnBoardingAdapter


class OnBoardFragment : Fragment() {
    private lateinit var  binding: FragmentOnBoardBinding



    private val adapter = OnBoardingAdapter(this::onStartClick)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewPager.adapter = adapter
        binding.indicator.setViewPager(binding.viewPager)
        adapter.registerAdapterDataObserver(binding.indicator.adapterDataObserver)
    }

    private fun onStartClick(){
        findNavController().navigateUp()
    }

}