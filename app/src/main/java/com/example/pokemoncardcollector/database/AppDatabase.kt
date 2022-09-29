package com.example.pokemoncardcollector.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pokemoncardcollector.dao.CardDao
import com.example.pokemoncardcollector.dao.SetDao
import com.example.pokemoncardcollector.entities.Card
import com.example.pokemoncardcollector.entities.Set

@Database(entities = [Card::class, Set::class], version = 1)
abstract class AppDatabase: RoomDatabase(){
    abstract fun setDao(): SetDao
    abstract fun cardDao(): CardDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "app_database")
                    .build()
                INSTANCE = instance

                instance
            }
        }


    }
}