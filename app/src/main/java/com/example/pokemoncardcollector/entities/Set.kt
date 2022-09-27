package com.example.pokemoncardcollector.entities
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Set (

    @PrimaryKey val id: String,
                val name: String,
                val series: String,
                val printTotal: Int,
                val Total: Int,
                val images: HashMap<String, String>
)