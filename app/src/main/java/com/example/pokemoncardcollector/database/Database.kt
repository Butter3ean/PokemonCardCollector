package com.example.pokemoncardcollector.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pokemoncardcollector.dao.CardDao
import com.example.pokemoncardcollector.dao.SetDao
import com.example.pokemoncardcollector.entities.Card
import com.example.pokemoncardcollector.entities.Set

@Database(entities = [Card::class, Set::class], version = 1)
abstract class Database: RoomDatabase(){
    abstract fun setDoa(): SetDao
    abstract fun cardDoa(): CardDao
}