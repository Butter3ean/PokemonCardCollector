package com.example.pokemoncardcollector.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.pokemoncardcollector.R
import com.example.pokemoncardcollector.apiclasses.Datum
import com.example.pokemoncardcollector.retrofitstuff.CardData
import com.example.pokemoncardcollector.databinding.FragmentAddBinding
import com.example.pokemoncardcollector.entities.Card
import com.example.pokemoncardcollector.viewmodels.CardViewModel
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AddFragment : Fragment() {

    private lateinit var cardViewModel: CardViewModel

    //View Binding for access to views
    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentAddBinding.inflate(inflater, container, false)

        cardViewModel = ViewModelProvider(this)[CardViewModel::class.java]

        //When clicked, the id from the edit text field is passed to retrive the data with that id from the api
        binding.addBtn.setOnClickListener {
            val id = binding.etCardId.editText?.text.toString()
            getApiData(id)
        }

        return binding.root

    }

    private fun getApiData(id: String) {
        //creates the url for retrofit with a GSON converter to convert JSON objects into data classes
        val retrofit = Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(CardData::class.java)
        val call = service.getCardData(id)

        call.enqueue(object : Callback<Datum> {

            //gets the data from the api and adds the needed fields to our card object
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
                            price!!,
                            datum.data.types[0]
                        )
                        //adds that card to the database
                        insertDataToDatabase(card)
                    }
                }
            }

            override fun onFailure(call: Call<Datum>?, t: Throwable?) {
                if (t != null) {
                    makeSnackBar("Unable to add Card")
                    println(t.message)
                }
            }
        })
    }

    //inserts the card into the database
    private fun insertDataToDatabase(card: Card) {
        cardViewModel.addCard(card)
        makeSnackBar("${card.name} Added!")
        findNavController().navigate(R.id.action_addFragment_to_listFragment)
    }

    //holds the url needed for the api
    companion object {
        var BaseUrl = "https://api.pokemontcg.io/"
    }

    //makes a snackbar message with a message passed to it
    fun makeSnackBar(msg: String) {
        val snack = Snackbar.make(binding.root, msg, Snackbar.LENGTH_SHORT)
        snack.show()

    }


}