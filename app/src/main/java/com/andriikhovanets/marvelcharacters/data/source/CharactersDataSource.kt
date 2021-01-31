package com.andriikhovanets.marvelcharacters.data.source

import androidx.lifecycle.LiveData
import com.andriikhovanets.marvelcharacters.data.Character
import com.andriikhovanets.marvelcharacters.data.Result

/**
 * Main entry point for accessing tasks data.
 */
interface CharactersDataSource {

    fun observeCharacters(): LiveData<Result<List<Character>>>

    suspend fun getCharacters(): Result<List<Character>>
}