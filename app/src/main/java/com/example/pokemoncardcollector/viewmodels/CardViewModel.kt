package com.example.pokemoncardcollector.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pokemoncardcollector.dao.CardDao
import com.example.pokemoncardcollector.entities.Card
import java.lang.IllegalArgumentException

class CardViewModel(private val cardDao: CardDao): ViewModel() {

    fun fullList(): List<Card> = cardDao.getAll()
}

class CardViewModelFactory(private val cardDao: CardDao): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(CardViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CardViewModel(cardDao) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}