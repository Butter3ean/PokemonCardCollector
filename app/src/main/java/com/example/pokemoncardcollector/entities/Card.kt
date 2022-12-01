package com.example.pokemoncardcollector.entities

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

//represents a table for cards in the database
@Parcelize
@Entity(tableName = "cards")
data class Card(

    @PrimaryKey val id: String,
    @ColumnInfo(name = "card_name") val name: String,
    @ColumnInfo(name = "super_type") val superType: String,
    @ColumnInfo(name = "level") val level: String?,
    @ColumnInfo(name = "HP") val hp: String?,
    @ColumnInfo(name = "evolves_from") val evolvesFrom: String?,
    @ColumnInfo(name = "set_name") val set: String,
    @ColumnInfo(name = "artist") val artist: String,
    @ColumnInfo(name = "rarity") val rarity: String,
    @ColumnInfo(name = "flavor_text") val flavorText: String?,
    @ColumnInfo(name = "image") val images: String,
    @ColumnInfo(name = "price") val price: Double?,
    @ColumnInfo(name = "type") val type: String?,
    @ColumnInfo(name = "national_dex_number") val nationalPokedexNumber: Int
): Parcelable






//
    //             @ColumnInfo(name = "national_dex_number") val nationalPokedexNumber: List<Int>,
//             @ColumnInfo(name = "rule") val rules: List<String>,
//             @ColumnInfo(name = "retreat_cost") val retreatCost: List<String>,
//    @NonNull @ColumnInfo(name = "type") val types: List<String>,
//    @NonNull @ColumnInfo(name = "sub_type") val subType: List<String>,


