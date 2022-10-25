package com.example.pokemoncardcollector.apiclasses

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import com.example.pokemoncardcollector.apiclasses.Datum
import retrofit2.http.Header
import retrofit2.http.Query

interface CardData {
    @GET("v2/cards/{id}?x_api_key=1ab3977c-2be4-4d39-9af5-c52c857edf5a")
    fun getCardData(@Path("id") id: String): Call<Datum>
}