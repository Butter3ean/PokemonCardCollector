package com.example.pokemoncardcollector.apiclasses

data class Datum(
    val count: Int,
    val `data`: Data,
    val page: Int,
    val pageSize: Int,
    val totalCount: Int
)