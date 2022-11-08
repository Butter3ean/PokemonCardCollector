package com.example.pokemoncardcollector.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.pokemoncardcollector.Constants
import com.example.pokemoncardcollector.retrofitstuff.CardData
import com.example.pokemoncardcollector.apiclasses.Datum
import com.example.pokemoncardcollector.databinding.FragmentAddBinding
import com.example.pokemoncardcollector.entities.Card
import com.example.pokemoncardcollector.viewmodels.CardViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AddFragment : Fragment() {

    private lateinit var cardViewModel: CardViewModel

    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddBinding.inflate(inflater, container, false)

        cardViewModel = ViewModelProvider(this)[CardViewModel::class.java]

        // Inflate the layout for this fragment
        binding.addBtn.setOnClickListener {
            val id = binding.etCardId.text.toString()
            getApiData(id)

        }

        return binding.root

    }

    private fun getApiData(id: String) {
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(CardData::class.java)
        val call = service.getCardData(id)


        call.enqueue(object : Callback<Datum> {

            override fun onResponse(call: Call<Datum>?, response: Response<Datum>?) {
                if (response != null) {
                    if (response.code() == 200) {
                        val datum = response.body()!!

                        var price = datum.data.tcgplayer.prices.normal?.low
                        val price1 = datum.data.tcgplayer.prices.holofoil?.low

                        if (price == null) {
                            price = price1
                        }

                        val card = Card(
                            datum.data.id,
                            datum.data.name,
                            datum.data.supertype,
                            datum.data.level,
                            datum.data.hp,
                            datum.data.evolvesFrom,
                            datum.data.convertedRetreatCost,
                            datum.data.set.name,
                            datum.data.artist,
                            datum.data.rarity,
                            datum.data.flavorText,
                            datum.data.images.large,
                            price!!
                        )
                        insertDataToDatabase(card)
                    }
                }
            }

            override fun onFailure(call: Call<Datum>?, t: Throwable?) {
                if (t != null) {
                    println(t.message)
                }
            }

        })
    }

    private fun insertDataToDatabase(card: Card) {
        cardViewModel.addCard(card)
        Toast.makeText(requireContext(), "Card Added", Toast.LENGTH_SHORT).show()
        findNavController().popBackStack()
    }

}