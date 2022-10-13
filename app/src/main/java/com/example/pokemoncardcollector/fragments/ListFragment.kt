package com.example.pokemoncardcollector.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokemoncardcollector.R
import com.example.pokemoncardcollector.databinding.ActivityMainBinding
import com.example.pokemoncardcollector.databinding.FragmentListBinding
import com.example.pokemoncardcollector.viewmodels.CardViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton


class ListFragment : Fragment() {

    private lateinit var cardViewModel: CardViewModel

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment

        val adapter = ListAdapter()
        val recyclerView = binding.recyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        cardViewModel = ViewModelProvider(this)[CardViewModel::class.java]
        cardViewModel.readAll.observe(viewLifecycleOwner, Observer {card ->
            adapter.setData(card)
        })

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

        return binding.root

    }


}