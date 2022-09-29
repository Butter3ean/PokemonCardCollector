package com.example.pokemoncardcollector

import android.app.Application
import com.example.pokemoncardcollector.database.AppDatabase

class PokemonCardCollectorApplication : Application() {

    val database: AppDatabase by lazy { AppDatabase.getDatabase(this) }
}