package com.example.pokemoncardcollector.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.pokemoncardcollector.entities.Card

//contains the methods for accessing the database
@Dao
interface CardDao {

    @Query("SELECT * FROM cards ORDER BY card_name ASC")
    fun getAll(): LiveData<List<Card>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addCard(card: Card)

    @Delete
    suspend fun deleteCard(card: Card)
}

