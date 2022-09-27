package com.example.pokemoncardcollector.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Card(

    @PrimaryKey val id: String,
                val name: String,
                val superType: String,
                val subType: List<String>,
                val level: String,
                val hp: String,
                val types: List<String>,
                val evolvesFrom: List<String>,
                val evolvesTo: List<String>,
                val rules: List<String>,
                val ancientTrait: HashMap<String, String>,
                val abilities: List<HashMap<String, String>>,
                val attacks: List<HashMap<String, String>>,
                val weaknesses: List<HashMap<String, String>>,
                val resistances: List<HashMap<String, String>>,
                val retreatCost: List<String>,
                val convertedRetreatCost: Int,
                val set: HashMap<String, String>,
                val number: String,
                val artist: String,
                val rarity: String,
                val flavorText: String,
                val nationalPokedexNumber: List<Int>,
                val regulationMark: String,
                val images: String,
                val tcgplayer: String,

)
