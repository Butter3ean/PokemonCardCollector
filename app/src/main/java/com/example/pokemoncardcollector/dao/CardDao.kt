package com.example.pokemoncardcollector.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.pokemoncardcollector.entities.Card

//the dao is responsible for defining the methods that access the database
@Dao
interface CardDao {

    //gets all cards in from the database in asc order by name
    @Query("SELECT * FROM cards ORDER BY card_name ASC")
    fun getAll(): LiveData<List<Card>>

    //adds a card to the database
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addCard(card: Card)

    //deletes a single card from the database
    @Delete
    suspend fun deleteCard(card: Card)

    //deletes all cards from the database
    @Query("DELETE FROM cards")
    suspend fun delete()
}

