package com.example.pokemoncardcollector.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.pokemoncardcollector.databinding.FragmentInfoBinding
import com.squareup.picasso.Picasso
import java.text.DecimalFormat

class InfoFragment : Fragment() {

    private val args by navArgs<InfoFragmentArgs>()

    private var _binding: FragmentInfoBinding? = null
    private val binding get() = _binding!!

    private val picasso: Picasso = Picasso.get()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentInfoBinding.inflate(inflater, container, false)

        //Adds all relevent information about a card to the views in the fragment
        picasso.load(args.currentCard.images)
            .into(binding.cardImage)
        binding.tvCardName.append(args.currentCard.name)
        binding.tvArtist.append(args.currentCard.artist)
        binding.tvHp.append(args.currentCard.hp)
        val decimalFormat = DecimalFormat("0.00")
        binding.tvCardPrice.append("$ ${decimalFormat.format(args.currentCard.price)}")
        binding.tvCardType.append(args.currentCard.superType)
        binding.tvSetName.append(args.currentCard.set)

        return binding.root
    }

}