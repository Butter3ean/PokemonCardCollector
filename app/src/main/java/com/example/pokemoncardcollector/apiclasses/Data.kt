package com.example.pokemoncardcollector.apiclasses

data class Data(
    val artist: String,
    val attacks: List<Attack>,
    val convertedRetreatCost: Int,
    val evolvesTo: List<String>,
    val evolvesFrom: String,
    val hp: String,
    val level: String?,
    val id: String,
    val images: Images,
    val legalities: Legalities,
    val name: String,
    val nationalPokedexNumbers: List<Int>,
    val number: String,
    val rarity: String,
    val retreatCost: List<String>,
    val rules: List<String>,
    val `set`: Set,
    val subtypes: List<String>,
    val supertype: String,
    val tcgplayer: Tcgplayer,
    val types: List<String>,
    val weaknesses: List<Weaknesses>,
    val flavorText: String
)