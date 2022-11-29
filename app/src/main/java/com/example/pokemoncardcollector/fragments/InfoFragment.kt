package com.example.pokemoncardcollector.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.pokemoncardcollector.databinding.FragmentInfoBinding
import com.example.pokemoncardcollector.viewmodels.ImageViewModel
import com.squareup.picasso.Picasso


class InfoFragment : Fragment() {

    private var _binding: FragmentInfoBinding? = null
    private val binding get() = _binding!!
    private val picasso: Picasso = Picasso.get()

    private val viewModel: ImageViewModel by activityViewModels()



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentInfoBinding.inflate(inflater, container, false)

        return binding.root
    }





}