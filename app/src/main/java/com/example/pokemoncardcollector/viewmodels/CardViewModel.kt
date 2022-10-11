package com.example.pokemoncardcollector.viewmodels

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.pokemoncardcollector.PokemonCardCollectorApplication
import com.example.pokemoncardcollector.database.AppDatabase
import com.example.pokemoncardcollector.database.CardRepo
import com.example.pokemoncardcollector.entities.Card
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CardViewModel(application: PokemonCardCollectorApplication): AndroidViewModel(application) {

    private val readAll: LiveData<List<Card>>
    private val repo: CardRepo


    init {
        val cardDao = AppDatabase.getDatabase(application).cardDao()
        repo = CardRepo(cardDao)
        readAll = repo.readAllData

    }

    fun addCard(card: Card) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.addCard(card)
        }
    }
}