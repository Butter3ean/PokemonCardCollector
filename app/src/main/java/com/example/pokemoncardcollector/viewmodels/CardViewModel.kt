package com.example.pokemoncardcollector.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.pokemoncardcollector.database.AppDatabase
import com.example.pokemoncardcollector.database.CardRepo
import com.example.pokemoncardcollector.entities.Card
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//provides data to the ui and the data is able to survive config changes like screen rotation.
//the viewModel acts as a comm center between the repo and UI
class CardViewModel(application: Application): AndroidViewModel(application) {

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