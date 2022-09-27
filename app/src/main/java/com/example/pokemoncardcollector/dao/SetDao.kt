package com.example.pokemoncardcollector.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.pokemoncardcollector.entities.Set

@Dao
interface SetDao {
    @Query("SELECT * FROM `Set`")
    fun getAll(): List<Set>

    @Query("SELECT * FROM `Set` WHERE id IN (:id)")
    fun loadAllByIds(id: String): List<Set>

    @Query("SELECT * FROM `Set` WHERE name LIKE :name LIMIT 1")
    fun findByName(name: String): Set

    @Insert
    fun insert(set: Set)

    @Delete
    fun delete(set: Set)
}