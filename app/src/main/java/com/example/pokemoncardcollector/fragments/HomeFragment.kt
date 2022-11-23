package com.example.pokemoncardcollector.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.pokemoncardcollector.R
import com.example.pokemoncardcollector.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        //all code goes for fragment
        binding.viewCollectionBtn.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_listFragment2)
        }

        return binding.root
    }
}