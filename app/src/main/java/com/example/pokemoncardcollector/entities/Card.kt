package com.example.pokemoncardcollector.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//table for cards in the database
@Entity(tableName = "cards")
data class Card(

    @PrimaryKey val id: String,
    @NonNull @ColumnInfo(name = "card_name") val name: String,
    @NonNull @ColumnInfo(name = "super_type") val superType: String,
//    @NonNull @ColumnInfo(name = "sub_type") val subType: List<String>,
    @ColumnInfo(name = "level") val level: String?,
    @ColumnInfo(name = "HP") val hp: String,
//    @NonNull @ColumnInfo(name = "type") val types: List<String>,
    @ColumnInfo(name = "evolves_from") val evolvesFrom: String,
//             @ColumnInfo(name = "evolves_to") val evolvesTo: List<String>,
//             @ColumnInfo(name = "rule") val rules: List<String>,
//             @ColumnInfo(name = "retreat_cost") val retreatCost: List<String>,
    @ColumnInfo(name = "converted_retreat_cost") val convertedRetreatCost: Int,
    @NonNull @ColumnInfo(name = "set_name") val set: String,
    @NonNull @ColumnInfo(name = "artist") val artist: String,
    @NonNull @ColumnInfo(name = "rarity") val rarity: String,
    @ColumnInfo(name = "flavor_text") val flavorText: String,
//             @ColumnInfo(name = "national_dex_number") val nationalPokedexNumber: List<Int>,
    @NonNull @ColumnInfo(name = "image") val images: String,
    @NonNull @ColumnInfo(name = "price") val price: Double,

    )
