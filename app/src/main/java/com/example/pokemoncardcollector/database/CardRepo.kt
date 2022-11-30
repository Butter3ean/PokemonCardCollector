package com.example.pokemoncardcollector.database

import androidx.lifecycle.LiveData
import com.example.pokemoncardcollector.dao.CardDao
import com.example.pokemoncardcollector.entities.Card

class CardRepo(private val cardDao: CardDao) {

    val readAllData: LiveData<List<Card>> = cardDao.getAll()
    val readAllDataByPriceAsc: LiveData<List<Card>> = cardDao.getAllByPriceAsc()
    val readAllDataByPriceDesc: LiveData<List<Card>> = cardDao.getAllByPriceDesc()

    suspend fun addCard(card: Card) {
        cardDao.addCard(card)
    }

    suspend fun deleteCard(card: Card) {
        cardDao.deleteCard(card)
    }

    suspend fun delete() {
        cardDao.delete()
    }
}