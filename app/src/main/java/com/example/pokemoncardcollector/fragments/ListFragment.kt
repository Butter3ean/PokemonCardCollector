package com.example.pokemoncardcollector.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.*
import com.example.pokemoncardcollector.R
import com.example.pokemoncardcollector.databinding.FragmentListBinding
import com.example.pokemoncardcollector.viewmodels.CardViewModel
import com.google.android.material.snackbar.Snackbar

class ListFragment : Fragment() {

    private lateinit var cardViewModel: CardViewModel

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentListBinding.inflate(inflater, container, false)

        cardViewModel = ViewModelProvider(this)[CardViewModel::class.java]

        //Gets the ListAdapter and adds it to the recyclerView
        val adapter = ListAdapter(cardViewModel)
        val recyclerView = binding.recyclerView
        recyclerView.adapter = adapter

        //Creates the layout for the recyclerView, making it a grid with 3 columns
        recyclerView.layoutManager =
            GridLayoutManager(requireContext(), 3, GridLayoutManager.VERTICAL, false)

        //observes data changes to the database and sets the data in the adapter
        cardViewModel.readAll.observe(viewLifecycleOwner) { card ->
            adapter.setData(card)
        }

        //When clicking on the Add Btn, it takes the user to the Add Fragment
        binding.addBtn.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

        //When clicking on the delete btn, a snackbar shows up and asks to confirm the deletion of all cards from the database,
        //if user selects cards, all cards are removed from the database
        binding.deleteButton.setOnClickListener {
            val snack = Snackbar.make(it, "Delete all Cards?", Snackbar.LENGTH_LONG)
            snack.setAction("Confirm", View.OnClickListener {
                cardViewModel.delete()
            })
            snack.show()
        }

        //If the delete and add button are not visible, clicking the menu button will make
        //the add and delete btns visible or will hide them
        binding.menuButton.setOnClickListener {
            if (binding.deleteButton.visibility == View.GONE) {
                binding.deleteButton.visibility = View.VISIBLE
                binding.addBtn.visibility = View.VISIBLE
            } else {
                binding.deleteButton.visibility = View.GONE
                binding.addBtn.visibility = View.GONE
            }

        }

        return binding.root

    }
}


