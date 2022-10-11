package com.example.pokemoncardcollector

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.pokemoncardcollector.apiclasses.CardData
import com.example.pokemoncardcollector.apiclasses.Datum
import com.example.pokemoncardcollector.apiclasses.Holofoil
import com.example.pokemoncardcollector.entities.Card
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etCardName: EditText = findViewById(R.id.cardIdEditText)
        val getDataBtn: Button = findViewById(R.id.addBtn)



        getDataBtn.setOnClickListener {
            val cardID = etCardName.text.toString()

            getData(cardID)
        }

    }

    private fun getData(cardID: String) {

        val retrofit = Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(CardData::class.java)
        val call = service.getCardData(cardID)


        call.enqueue(object : Callback<Datum> {

            override fun onResponse(call: Call<Datum>?, response: Response<Datum>?) {
                if (response != null) {
                    if (response.code() == 200) {
                        val datum = response.body()!!

                        var price = datum.data.tcgplayer.prices.normal?.low
                        val price1 = datum.data.tcgplayer.prices.holofoil?.low

                       if(price == null) {
                           price = price1
                       }

                        val card: Card = Card(
                            datum.data.id,
                            datum.data.name,
                            datum.data.supertype,
                            datum.data.subtypes,
                            datum.data.level,
                            datum.data.hp,
                            datum.data.types,
                            datum.data.evolvesFrom,
                            datum.data.evolvesTo,
                            datum.data.rules,
                            datum.data.retreatCost,
                            datum.data.convertedRetreatCost,
                            datum.data.set.name,
                            datum.data.artist,
                            datum.data.rarity,
                            datum.data.flavorText,
                            datum.data.nationalPokedexNumbers,
                            datum.data.images.large,
                            price!!
                            )
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


    companion object {
        var BaseUrl = "https://api.pokemontcg.io/"
    }
}