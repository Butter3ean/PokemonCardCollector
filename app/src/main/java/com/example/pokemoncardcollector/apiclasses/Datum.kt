package com.example.pokemoncardcollector.apiclasses

import com.example.pokemoncardcollector.apiclasses.Data

data class Datum(
    val count: Int,
    val `data`: Data,
    val page: Int,
    val pageSize: Int,
    val totalCount: Int
)