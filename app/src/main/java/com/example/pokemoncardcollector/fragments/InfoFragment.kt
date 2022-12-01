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
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentInfoBinding.inflate(inflater, container, false)

        val decimalFormat = DecimalFormat("0.00")

        //Adds all relevent information about a card to the views in the fragment
        picasso.load(args.currentCard.images)
            .into(binding.cardImage)
        binding.tvCardFlavText.append(args.currentCard.superType)
        binding.tvArtist.append(args.currentCard.artist)
        binding.tvSetName.append(args.currentCard.set)
        binding.tvCardType.append(args.currentCard.type)
        binding.tvCardPrice.append(decimalFormat.format(args.currentCard.price))
        binding.tvCardRarity.append(args.currentCard.rarity)
        binding.tvDexNo.append(args.currentCard.nationalPokedexNumber.toString())
        binding.tvCardName.append(args.currentCard.name)

        return binding.root
    }

}