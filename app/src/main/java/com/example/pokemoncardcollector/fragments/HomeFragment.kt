package com.example.pokemoncardcollector.fragments

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.fragment.findNavController
import com.example.pokemoncardcollector.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        //all code goes for fragment
        binding.simpleImageButton1.setOnClickListener{
            //findNavController().navigate(R.id.action)
        }
        
        /*newButton?.setOnClickListener(View.OnClickListener() {
            fun onClick(v: View?) {
                
            }
        })*/
        return binding.root
    }




}