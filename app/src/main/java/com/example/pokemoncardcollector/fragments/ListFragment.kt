package com.example.pokemoncardcollector.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pokemoncardcollector.R
import com.example.pokemoncardcollector.databinding.FragmentListBinding
import com.example.pokemoncardcollector.viewmodels.CardViewModel


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

        cardViewModel = ViewModelProvider(this)[CardViewModel::class.java]

        val adapter = ListAdapter(cardViewModel)
        val recyclerView = binding.recyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)

        cardViewModel.readAll.observe(viewLifecycleOwner) { card ->
            adapter.setData(card)
        }



        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }



        return binding.root

    }

}