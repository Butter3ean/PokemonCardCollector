package com.example.pokemoncardcollector.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.pokemoncardcollector.entities.Card

@Dao
interface CardDao {

    @Query("SELECT * FROM card")
    fun getAll(): List<Card>

    @Insert
    fun insertAll(card: Card)

    @Delete
    fun delete(card: Card)
}

