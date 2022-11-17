package com.example.pokemoncardcollector.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.pokemoncardcollector.databinding.FragmentImageBinding
import com.example.pokemoncardcollector.viewmodels.ImageViewModel
import com.google.mlkit.vision.common.InputImage

class ImageFragment : Fragment() {

    private var _binding: FragmentImageBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ImageViewModel by activityViewModels()

    private lateinit var image: InputImage

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentImageBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        binding.imageView.setImageURI(viewModel.item)


        return binding.root
    }








}