package com.andriikhovanets.marvelcharacters.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * The Data Access Object for the Character class.
 */
@Dao
interface CharacterDao {
    @Query("SELECT * FROM characters ORDER BY name")
    fun getCharacters(): LiveData<List<Character>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(characters: List<Character>)
}