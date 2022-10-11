package com.example.pokemoncardcollector.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.pokemoncardcollector.entities.Card

@Dao
interface CardDao {

    @Query("SELECT * FROM cards ORDER BY card_name ASC")
    fun getAll(): LiveData<List<Card>>

    @Insert
    suspend fun addCard(card: Card)

    @Delete
    fun deleteCard(card: Card)
}

